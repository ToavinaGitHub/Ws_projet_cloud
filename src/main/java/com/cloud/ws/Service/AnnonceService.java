package com.cloud.ws.Service;

import com.cloud.ws.Model.*;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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



    //Annonce d'un client

    public List<Annonce> getByUser(Utilisateur u){
        return annonceRepository.findAnnonceByUtilisateur(u);
    }

    public void save(Annonce annonce){
        annonceRepository.save(annonce);
    }

    public List<Annonce> getAll(){
        return annonceRepository.findAll();
    }

    // Maka annonce en cours de demande
    public List<Annonce> getAnnonceEnDemande(){
        return annonceRepository.findAnnonceByEtat(0);
    }

    public int nombreAnnonceEnDemande(){
        return annonceRepository.findAnnonceByEtat(0).size();
    }

    //Maka annonce izay mbola tsy vendu
    public List<Annonce> getAnnonceDispo(){
        return annonceRepository.findAnnonceByEtat(5);
    }

    //Maka Annonce par client par Etat
    public List<Annonce> getAnnonceClientEtat(int idClient,int etat){
        Utilisateur u = utilisateurRepository.findUtilisateurByIdUtilisateur(idClient);
        return annonceRepository.findAnnonceByUtilisateurAndEtat(u,etat);
    }

    //Izay efa vendu
    public List<Annonce> getAnnonceClientHistorique(int idClient){
        return this.getAnnonceClientEtat(idClient,10);
    }

    //Maka ny Annonces favoris par client
    public Vector<Annonce> getAnnonceFavorisClient(int idClient){
        return annonceFavorisRepository.getByUtilisateur(idClient);
    }

    public Annonce getById(int idAnnonce){
        return annonceRepository.findAnnonceByIdAnnonce(idAnnonce);
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
        try{
            annonceRepository.updateEtatObjet(etat,idAnnonce,prixVente);
            System.out.println("ato");
            return ResponseEntity.ok("Etat annonce modifié avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Etat annonce non modifié");
        }

    }

    //Valider Annonce
    public void ValiderAnnonce(int idAnnonce){
        try {
            this.updateEtatAnnonce(idAnnonce,0,5);
            ResponseEntity.ok("Annonce validé avec succes");
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Annonce non validé");
        }

    }

    //Refuser Annonce
    public void RefuserAnnonce(int idAnnonce){
        try {
            this.updateEtatAnnonce(idAnnonce,0,-5);
            ResponseEntity.ok("Annonce refusé avec succes");
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Annonce non validé");
        }
    }

    //Mettre Annonce en vendu
    public void AnnonceToVendu(int idAnnonce){
        try {
            this.updateEtatAnnonce(idAnnonce,0,10);
            ResponseEntity.ok("Annonce vendu avec succes");
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Annonce non validé");
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

    /*************Statistique***************/

    //Nombre d'annonce par mois par année
    public int[] nbAnnonceMoisAnnee(int annee){
        int[] res = new int[12];
        for (int i = 1; i <= 12 ; i++) {
            res[i-1] = annonceRepository.countByMoisAndAnnee(i,annee);
        }
        return res;
    }

    //Nombre annonce par mois par année par jour
    public int[] nbAnnonceMoisAnneeJours(int mois,int annee){
        int[] res = new int[30];

        for (int i = 1; i <=res.length; i++) {
            res[i-1] = annonceRepository.countByMoisAndAnneeAndJour(mois,annee,i);
        }
        return res;
    }

    //Nombre de voiture vendu par mois par année
    public int[] nbVoitureVenduMoisAnnee(int annee){
        int[] res = new int[12];
        for (int i = 1; i <= 12 ; i++) {
            res[i-1] = annonceRepository.voitureVenduParMoisParAnnee(i,annee);
        }
        return res;
    }

    //Voiture par marque par mois par année

    public int[] nbVoitureMarqueVenduMoisAnnee(int idMarque,int annee){
        int[] res = new int[12];
        for (int i = 1; i <= 12 ; i++) {
            res[i-1] = annonceRepository.voitureMarqueVenduParMoisParAnnee(idMarque,i,annee);
        }
        return res;
    }

    //Marque mar mois
    public List<String> bestSoldes(int annee){
        List<Marque> all = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 12 ; i++) {
           res.add((annonceRepository.bestCarSoldes(i,annee)));
        }
        return res;
    }

    public List<Integer> bestSoldesCount(int annee){
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 12 ; i++) {
            res.add((annonceRepository.bestCarSoldesCount(i,annee)));
        }
        return res;
    }



    //Nombre de voiture vendu par mois par année par jour
    public int[] nbVoitureVenduMoisAnneeJours(int mois,int annee){
        int[] res = new int[30];

        for (int i = 1; i <=res.length; i++) {
            res[i-1] = annonceRepository.voitureVenduParMoisParAnneeParJours(mois,annee,i);
        }
        return res;
    }

    //Prix de voiture par mois par année
    public Double[] prixParMois(int annee){
        Double[] res = new Double[12];
        for (int i = 1; i <= 12 ; i++) {
            res[i-1] = annonceRepository.prixMoyenneVenduParMoisParAnnee(i,annee);
        }
        return res;
    }

    public Double revenuAnnuel(int annee){
        return annonceRepository.prixParAns(annee);
    }

    /*--------------------Recherche multiple---------------------*/

    public List<Annonce> searchAnnonces(RechercheMultiple rechercheMultiple) {
         List<Annonce> allAnnonces = annonceRepository.findAnnonceByEtat(5);


        return allAnnonces.stream()
                .filter(annonce -> matchCriteria(annonce, rechercheMultiple))
                .collect(Collectors.toList());
    }

    private boolean matchCriteria(Annonce annonce, RechercheMultiple rechercheMultiple) {
        boolean matchKeyword = rechercheMultiple.getKeyword() == null ||
                annonce.getDescription().toLowerCase().contains(rechercheMultiple.getKeyword().toLowerCase());


        boolean matchCategorie = rechercheMultiple.getCategorie() == null ||
                annonce.getModele().getCategorie().getIdCategorie()==rechercheMultiple.getCategorie().getIdCategorie();

        boolean matchMarque = rechercheMultiple.getMarque() == null ||
                annonce.getModele().getMarque().getIdMarque()==rechercheMultiple.getMarque().getIdMarque();

        boolean matchModele = rechercheMultiple.getModele() == null ||
                annonce.getModele().getIdModele()==rechercheMultiple.getModele().getIdModele();

        boolean matchPrix = (rechercheMultiple.getPrixMin()==0 && rechercheMultiple.getPrixMax()==0) || (annonce.getPrixDemande()>=rechercheMultiple.getPrixMin() && annonce.getPrixDemande()<=rechercheMultiple.getPrixMax());


        boolean matchKilometrage = (rechercheMultiple.getMinKilometrage()==0 && rechercheMultiple.getMaxKilometrage()==0) || (Double.parseDouble(annonce.getKilometrage())>=rechercheMultiple.getMinKilometrage() && Double.parseDouble(annonce.getKilometrage())<=rechercheMultiple.getMaxKilometrage());

        boolean matchDate = (rechercheMultiple.getMinDate()==null && rechercheMultiple.getMaxDate()==null) || annonce.getDateAnnonce().after(rechercheMultiple.getMinDate()) && annonce.getDateAnnonce().before(rechercheMultiple.getMaxDate());

        return  matchDate & matchKilometrage & matchPrix &  matchKeyword && matchDate && matchCategorie & matchModele & matchMarque;

    }


}
