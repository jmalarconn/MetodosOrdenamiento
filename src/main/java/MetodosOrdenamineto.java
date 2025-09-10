public class MetodosOrdenamineto {
    int MAX = 20;
    int a[];
    public MetodosOrdenamineto(){
        a = new int [MAX];
    }
    void crearArreglo(){
        for(int i=0;i<MAX;i++)
            a[i] = (int)(Math.random()*1000+1);
    }
    String mostrarArreglo(int n){
        if(n<0) return "";
        else return a[n]+" "+mostrarArreglo(n-1);
    }
    int sumaElementos(int n){
        if(n<0) return 0;
        else return a[n]+sumaElementos(n-1);
    }
    int contarPares(int n){
        if(n<0) return 0;
        else {
            if(a[n]%2==0)
                return 1+contarPares(n-1);
            else return contarPares(n-1);
        }
    }
    int buscarElemento(int n, int x){
        if(n<0) return -1;
        else{
            if(x == a[n])
                return n;
            else
                return buscarElemento(n-1,x);
        }
    }
    int contarMayores(int n, int x){
        if(n<0) return 0;
        else if(a[n]>=x)
            return 1+contarMayores(n-1,x);
        else return contarMayores(n-1,x);
    }

    // MÉTODO NUEVO: Sumar elementos menores que un valor dado
    int sumarMenores(int n, int x){
        if(n<0) return 0;
        else {
            if(a[n] < x)
                return a[n] + sumarMenores(n-1, x);
            else
                return sumarMenores(n-1, x);
        }
    }

    // MÉTODO NUEVO: Sumar elementos impares
    int sumarImpares(int n){
        if(n<0) return 0;
        else {
            if(a[n]%2 != 0)
                return a[n] + sumarImpares(n-1);
            else
                return sumarImpares(n-1);
        }
    }
}