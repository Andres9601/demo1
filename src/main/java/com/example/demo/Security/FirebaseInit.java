package com.example.demo.Security;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class FirebaseInit {

	
	//private static FirebaseOptions firebaseOptions;
	//private static FileInputStream serviceAccount; 
	//private static final String FIREBASE_CONFIG = "./src/main/resources/firebase.json";
	//private static final String FIREBASE_CONFIG = System.getenv("FIREBASE_JSON");
	

	

	
	private static final Logger logger =  Logger.getLogger(FirebaseInit.class.getName());


	public void inicializacion() throws FirebaseAuthException, IOException {
		
		// Cargar archivo firebase.json en FirebaseOptions
		ClassPathResource resource = new ClassPathResource("firebase.json");
		InputStream inputStream = resource.getInputStream();
		String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		FirebaseOptions options = new FirebaseOptions.Builder()
		    .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(json.getBytes())))
		    .build();
		FirebaseApp.initializeApp(options);
		
		
		/*try {
			serviceAccount = new FileInputStream(FIREBASE_CONFIG);
			firebaseOptions = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();
			FirebaseApp.initializeApp(firebaseOptions);
			logger.info("inicializado");
		} catch (Exception e){
			logger.info("no inicializado");
		}*/
		
		}
	
	
	

}

