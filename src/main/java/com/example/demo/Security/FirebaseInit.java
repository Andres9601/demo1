package com.example.demo.Security;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class FirebaseInit {

	private static final Logger logger =  Logger.getLogger(FirebaseInit.class.getName());

	
    private static FirebaseOptions firebaseOptions;
	private static FileInputStream serviceAccount; 
	//private static final String FIREBASE_CONFIG = "./src/main/resources/firebase.json";
	//private static final String FIREBASE_CONFIG = System.getenv("FIREBASE_JSON");



	//public static void inicializacion() throws FirebaseAuthException {
		
	
	private static final String FIREBASE_CONFIG = "firebase.json";
	public static void inicializacion() throws FirebaseAuthException {
	    try {
	        InputStream serviceAccount = FirebaseInit.class.getClassLoader().getResourceAsStream(FIREBASE_CONFIG);
	        firebaseOptions = new FirebaseOptions.Builder()
	                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	                .build();
	        FirebaseApp.initializeApp(firebaseOptions);
	        logger.info("inicializado");
	    } catch (Exception e) {
	    }
	}


}

