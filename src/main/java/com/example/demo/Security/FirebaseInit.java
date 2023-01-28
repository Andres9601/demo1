package com.example.demo.Security;

import java.io.FileInputStream;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class FirebaseInit {
	
	@Autowired
	private Environment env;
	
	private static FirebaseOptions firebaseOptions;
	private static FileInputStream serviceAccount; 
	//private static final String FIREBASE_CONFIG = "firebase.json";
	private static final String FIREBASE_CONFIG = System.getenv("FIREBASE_JSON");
	
	
	
	private static final Logger logger =  Logger.getLogger(FirebaseInit.class.getName());


	public void inicializacion() throws FirebaseAuthException {
		
		
		try {
			serviceAccount = new FileInputStream(FIREBASE_CONFIG);
			firebaseOptions = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();
			FirebaseApp.initializeApp(firebaseOptions);
			logger.info("inicializado");
		} catch (Exception e){
			logger.info("no inicializado");
		}
		
		}
	
	
	

}

