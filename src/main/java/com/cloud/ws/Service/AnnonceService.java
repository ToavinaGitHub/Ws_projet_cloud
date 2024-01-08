package com.cloud.ws.Service;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.AnnonceFavoris;
import com.cloud.ws.Model.SaryAnnonce;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.AnnonceFavorisRepository;
import com.cloud.ws.Repository.AnnonceRepository;
import com.cloud.ws.Repository.SaryAnnonceRepository;
import com.cloud.ws.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Vector;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    AnnonceFavorisRepository annonceFavorisRepository;

    @Autowired
    SaryAnnonceRepository saryAnnonceRepository;

    public Vector<Annonce> getAll(){
        return (Vector<Annonce>) annonceRepository.findAll();
    }

    // Maka annonce en cours de demande
    public Vector<Annonce> getAnnonceEnDemande(){
        return annonceRepository.findAnnonceByEtat(0);
    }

    //Maka annonce izay mbola tsy vendu
    public Vector<Annonce> getAnnonceDispo(){
        return annonceRepository.findAnnonceByEtat(5);
    }

    //Maka Annonce par client par Etat
    public Vector<Annonce> getAnnonceClientEtat(int idClient,int etat){
        Utilisateur u = utilisateurRepository.findUtilisateurByIdUtilisateur(idClient);
        return annonceRepository.findAnnonceByUtilisateurAndEtat(u,etat);
    }

    //Izay efa vendu
    public Vector<Annonce> getAnnonceClientHistorique(int idClient){
        return this.getAnnonceClientEtat(idClient,10);
    }

    //Maka ny Annonces favoris par client
    public Vector<Annonce> getAnnonceFavorisClient(int idClient){
        return annonceFavorisRepository.getByUtilisateur(idClient);
    }

    //Mettre annonce en favoris
    public String setAnnonceToFav(int idUser, int idAnnonce) throws Exception {
        Annonce a = annonceRepository.findAnnonceByIdAnnonce(idAnnonce);
        Utilisateur user = utilisateurRepository.findUtilisateurByIdUtilisateur(idUser);
        AnnonceFavoris anFav = new AnnonceFavoris();
        anFav.setAnnonce(a);
        anFav.setUtilisateur(user);

        String response ="";
        try{
            annonceFavorisRepository.save(anFav);
            response = "{\"success\":1, \"message\":\"Annonce ajouté aux favoris\"}";
        }catch (Exception e){
            throw new Exception("Annonce favoris non Inseré");
        }
        response =  "{\"success\":0, \"message\":\"Annonce non-ajouté aux favoris\"}";
        return response;
    }


    //Modifier Etat Annonce
    public ResponseEntity<String> updateEtatAnnonce(int idAnnonce,double prixVente,int etat){
        Annonce a = annonceRepository.findAnnonceByIdAnnonce(idAnnonce);
        Annonce temp  = new Annonce(idAnnonce,a.getKilometrage(),a.getNbPorte(),a.getDescription(),a.getPrixDemande(),prixVente,etat,a.getDateAnnonce(),a.getCommission(),a.getUtilisateur(),a.getTransmission(),a.getCarburant(),a.getModele());

        try{
            annonceRepository.delete(a);
            annonceRepository.save(temp);
            return ResponseEntity.ok("Etat annonce modifié avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Etat annonce non modifié");
        }

    }

    //Valider Annonce
    public ResponseEntity<String> ValiderAnnonce(int idAnnonce){
        try {
            this.updateEtatAnnonce(idAnnonce,0,5);
            return ResponseEntity.ok("Annonce validé avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Annonce non validé");
        }

    }

    //Inserer Annonce
    public ResponseEntity<String> insertAnnonce(Annonce a){

        try {
            annonceRepository.save(a);
            return ResponseEntity.ok("Annonce inseré avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Annonce non inseré");
        }

    }

    //Encode file to base64
    public String encodeFile(String inputfile) throws IOException {
        byte[] input_file = Files.readAllBytes(Paths.get(inputfile));
        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
        String encodedString =  new String(encodedBytes);

        return encodedString;
    }

    //Decode base64 to file
    public void decodeFile(String encodedfilecontent, String decodedfile) throws IOException {
        byte[] decoded = Base64.getDecoder().decode(encodedfilecontent);
        String decodedString =  new String(decoded);

        File ff =  new File(decodedfile);
        FileOutputStream fileOut = new FileOutputStream(ff);
        OutputStreamWriter outStream = new OutputStreamWriter(fileOut);
        outStream.write(decodedString);
        outStream.flush();
    }

    //Save Annonce Sary

        public ResponseEntity<String> saveAnnonceSary(int idAnnonce , String inputFile) throws Exception {
        try {
            String base64 = this.encodeFile(inputFile);

            Annonce a = annonceRepository.findAnnonceByIdAnnonce(idAnnonce);

            SaryAnnonce saryAnnonce = new SaryAnnonce();
            saryAnnonce.setAnnonce(a);
            saryAnnonce.setSary(base64);

            saryAnnonceRepository.save(saryAnnonce);
            return ResponseEntity.ok("Sary annonce non inseré");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sary Annonce non inseré");
        }
    }

}
