package recursos;

public class Hilos extends Thread{
	int sum;
	int nums[]={1,2,3,4,5};
	
	
	public void run() {
        int resp;
        System.out.println(this.getName()+ " iniciando.");
        resp=sumArray(nums);
        System.out.println("Suma para "+this.getName()+ " es "+resp);
        System.out.println(this.getName()+ " terminado.");
	}
	
    synchronized int sumArray(int n[]){
        sum=0;
        for (int i=0; i<n.length;i++){
            sum+=n[i];
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+sum);
        try {
        	System.out.println("-"+Thread.currentThread().getName());
            Thread.sleep(10);//permitir el cambio de tarea
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido");
        }
        }
        return sum;
    }
}
