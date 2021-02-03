//This is the code for translating DNA to RNA to amino acid.
import java.util.*;

public class translation{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter DNA sequence (3' to 5', e.g. AGCTAATGA): ");
      String DNASequence = sc.nextLine();
      System.out.println("RNA sequence: " + getRNA(DNASequence));
      String RNA = getRNA(DNASequence);
      if (RNA.equals("Invalid")){
         System.out.println("Amino Acid sequence: Invalid");
      } else {
         System.out.println("Animo Acid sequence: " + getAminoAcid(RNA));
      }
   }
   
   public static String getRNA(String DNA){
      String RNA = "";
      for (int i = 0; i < DNA.length(); i++){
         String nucleotide = (DNA.substring(i, i+1));
         if (nucleotide.equals("A")){
            nucleotide = "U";
         } else if (nucleotide.equals("T")){
            nucleotide = "A";
         } else if (nucleotide.equals("C")){
            nucleotide = "G";
         } else if (nucleotide.equals("G")){
            nucleotide = "C";
         } else {
            return "Invalid";
         }
         RNA += nucleotide;
      } 
      return RNA;
   }
   
   public static String getAminoAcid(String RNA){
      List<String> phe = new ArrayList<String>();
      phe.add("UUU");
      phe.add("UUC");
      List<String> leu = new ArrayList<String>();
      leu.add("CUU");
      leu.add("CUC");
      leu.add("CUA");
      leu.add("CUG");
      leu.add("UUA");
      leu.add("UUG");
      List<String> ile = new ArrayList<String>();
      ile.add("AUU");
      ile.add("AUC");
      ile.add("AUA");
      List<String> metOrStart = new ArrayList<String>();
      metOrStart.add("AUG");
      List<String> val = new ArrayList<String>();
      val.add("GUU");
      val.add("GUC");
      val.add("GUA");
      val.add("GUG");
      List<String> ser = new ArrayList<String>();
      ser.add("UCU");
      ser.add("UCC");
      ser.add("UCA");
      ser.add("UCG");
      ser.add("AGU");
      ser.add("AGC");
      List<String> pro = new ArrayList<String>();
      pro.add("CCU");
      pro.add("CCC");
      pro.add("CCA");
      pro.add("CCG");
      List<String> thr = new ArrayList<String>();
      thr.add("ACU");
      thr.add("ACC");
      thr.add("ACA");
      thr.add("ACG");
      List<String> ala = new ArrayList<String>();
      ala.add("GCU");
      ala.add("GCC");
      ala.add("GCA");
      ala.add("GCG");
      //NEWLY ADDED BELOW
      List<String> tyr = new ArrayList<String>();
      tyr.add("UAU");
      tyr.add("UAC");
      List<String> his = new ArrayList<String>();
      his.add("CAU");
      his.add("CAC");
      List<String> gln = new ArrayList<String>();
      gln.add("CAA");
      gln.add("CAG");
      List<String> asn = new ArrayList<String>();
      asn.add("AAU");
      asn.add("AAC");
      List<String> lys = new ArrayList<String>();
      lys.add("AAA");
      lys.add("AAG");
      List<String> asp = new ArrayList<String>();
      asp.add("GAU");
      asp.add("GAC");
      List<String> glu = new ArrayList<String>();
      glu.add("GAA");
      glu.add("GAG");
      List<String> cys = new ArrayList<String>();
      cys.add("UGU");
      cys.add("UGC");
      List<String> trp = new ArrayList<String>();
      trp.add("UGG");
      List<String> arg = new ArrayList<String>();
      arg.add("CGU");
      arg.add("CGC");
      arg.add("CGA");
      arg.add("CGG");
      arg.add("AGA");
      arg.add("AGG");
      List<String> gly = new ArrayList<String>();
      gly.add("GGU");
      gly.add("GGC");
      gly.add("GGA");
      gly.add("GGG");
      List<String> stop = new ArrayList<String>();
      stop.add("UAA");
      stop.add("UAG");
      stop.add("UGA");
      Hashtable<String, List> aminoAcids = new Hashtable<String, List>();
      aminoAcids.put("Phe", phe);
      aminoAcids.put("Leu", leu);
      aminoAcids.put("Ile", ile);
      aminoAcids.put("Met/Start", metOrStart);
      aminoAcids.put("Val", val);
      aminoAcids.put("Ser", ser);
      aminoAcids.put("Pro", pro);
      aminoAcids.put("Thr", thr);
      aminoAcids.put("Ala", ala);
      aminoAcids.put("Tyr", tyr);
      aminoAcids.put("His", his);
      aminoAcids.put("Gln", gln);
      aminoAcids.put("Asn", asn);
      aminoAcids.put("Lys", lys);
      aminoAcids.put("Asp", asp);
      aminoAcids.put("Glu", glu);
      aminoAcids.put("Cys", cys);
      aminoAcids.put("Trp", trp);
      aminoAcids.put("Arg", arg);
      aminoAcids.put("Gly", gly);
      aminoAcids.put("Stop", stop);
      String aminoAcidString = "";
      // WITH SPACES BETWEEN CODONS IN THE DNA SEQUENCE (e.g. AGC TAA TGA)
      /*if (RNA.length() >=3){
         for (int i = 0; i < RNA.length(); i+=4){
            String codon = RNA.substring(i, i+3);
            for (Map.Entry mapElement : aminoAcids.entrySet()){
               String acids = (mapElement.getValue()).toString();
               if (acids.contains(codon)){
                  aminoAcidString += mapElement.getKey() + " ";
               }
            }
         }
      } else {
         System.out.println("Invalid");
      }*/
      // NO SPACES IN THE DNA SEQUENCE (e.g. AGCTAATGA)
      if (RNA.length() >=3){
         for (int i = 0; i < RNA.length(); i+=3){
            String codon = RNA.substring(i, i+3);
            for (Map.Entry mapElement : aminoAcids.entrySet()){
               String acids = (mapElement.getValue()).toString();
               if (acids.contains(codon)){
                  aminoAcidString += mapElement.getKey() + " ";
               }
            }
         }
      } else {
         System.out.println("Invalid");
      }
      return aminoAcidString;
   }
}
