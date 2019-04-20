package com.clarion.sacumen.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SacumenService {
	@Autowired
	HttpService httpService;
	
	@Value("${download.files.url}")
	private String downloadFilesUrl;
	
	public Map<String, List<String>> getFileIssueIdList() throws IOException, JSONException {
		Set<String> fileNames = getFileNames();
		Map<String, List<String>> fileIssueIdList = new HashMap<>();
		
		for(String fileName: fileNames) {
			fileIssueIdList.put(fileName, getIdFromFileUrl(fileName));
		}
		
		return fileIssueIdList;
	}
	
	public Set<String> getFileNames() throws JSONException, IOException {
		JSONObject main;
		JSONArray entries = null;
		Set<String> fileNames = new HashSet<>();
		
		main = new JSONObject(httpService.getContent(downloadFilesUrl));
		if(main != null)
			entries = main.optJSONArray("entries");
		
		for(int i=0; i<entries.length(); i++) {
			String downloadUrl = entries.getJSONObject(i).optString("download_url");
			if(downloadUrl.endsWith(".csv")) {
				fileNames.add(downloadUrl);
			}
		}
		return fileNames;
	}
	
	public List<String> getIdFromFileUrl(String fileUrl) throws IOException {
		String content = httpService.getContent(fileUrl);
		List<String> ids = new ArrayList<>();

	    Pattern p = Pattern.compile("\n\"([A-Za-z0-9-]+)\"");
	    Matcher m = p.matcher(content);
	    
	    while(m.find()) {
	    	ids.add(m.group(1));
	    }
	    
	    return ids;
	}
}
