package entidade;

public class Notas {
      
    private double np1;
    private double np2;
    private double sub;
    private double exame;
    private double media;
    private boolean status = false;
    
    public Notas(double aNp1, double aNp2, double aSub, double aExame) {
        this.np1 = aNp1;
        this.np2 = aNp2;
        this.sub = aSub;
        this.exame = aExame;
    }
    
    public double getNp1() {
        return this.np1;
    }
    public void setNp1(double np1) {
        this.np1 = np1;
    }
    public double getNp2() {
        return this.np2;
    }
    public void setNp2(double np2) {
        this.np2 = np2;
    }
    public double getSub() {
        return this.sub;
    }
    public void setSub(double sub) {
        this.sub = sub;
    }
    public double getExame() {
        return this.exame;
    }
    public void setExame(double exame) {
        this.exame = exame;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public double getMedia() {
        return this.media;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    
   public double calculaMediaFinal(double np1, double np2, double sub, double exame, Curso curso) {
       double media = 0;
       double mediaFinal = 0;
       String nivel = curso.getNivel();
       if (np1>sub && np2>sub){
           media = (np1+np2)/2;
           if (nivel == "GRADUACAO"){
               if (media >= 7){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
           else{
               if (media >= 5){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
       }
       else if (np1>np2 && sub>np2){
           media = (np1+sub)/2;
           if (nivel == "GRADUACAO"){
               if (media >= 7){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
           else{
               if (media >= 5){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
       }
       else if (np2>np1 && sub>np1){
           media = (np2+sub)/2;
           if (nivel == "GRADUACAO"){
               if (media >= 7){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
           else{
               if (media >= 5){
                   Notas.this.media = media;
                   Notas.this.status = true;
               }
               else{
                   mediaFinal = (media+exame)/2;
                   Notas.this.media = mediaFinal;
                   if (mediaFinal >= 5){
                       Notas.this.status = true;
                   }
               }
           }
       }
       return mediaFinal;
  } 
    
    @Override
    public String toString(){
        String resultado = "";
        resultado += "Np1: " + this.getNp1(); // + "\n"
        resultado += " Np2: " + this.getNp2();
        resultado += " Substutiva: " + this.getSub();
        resultado += " Exame: " + this.getExame();
        resultado += " Media: " + this.getMedia();
        if (this.getStatus()==true){
            resultado += " Aprovado";
        }
        else if (this.getStatus()==false){
            resultado += " Reprovado";
        }
        return resultado;
    }

}
