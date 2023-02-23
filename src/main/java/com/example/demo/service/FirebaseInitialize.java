package com.example.demo.service;

import java.io.FileInputStream;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitialize {
	
	Logger logger = LoggerFactory.getLogger(FirebaseInitialize.class);
	
	@PostConstruct
	public void initialize() {
		
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("./serviceAccountKey.json");

					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://streamfox-966e7.firebaseio.com/")
					  .build();

					FirebaseApp.initializeApp(options);
			        Firestore db = FirestoreClient.getFirestore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
