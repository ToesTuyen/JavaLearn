import java.util.Scanner;

public class BaiTap_1 {
    public static int nhap(){
        Scanner input= new Scanner(System.in);
        boolean check= false;
        int n=0;
        while(!check){
            System.out.print(" ");
            try{
                n= input.nextInt();
                check= true;
            }catch(Exception e){
                System.out.println("Bạn phải nhập số, hãy nhập lại...");
                input.nextLine();
            }
        }
        return (n);
    }
    public static int tongChuSo(int n){ int T=0;
        while(n>0){
            T+= n%10;
            n/= 10;
        }
        return (T);
    }
    //Ham kiem tra so nguyen to
    public static boolean checkSNT(int n){
        if(n>1){
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0) return false;
    }
        return true;
    }
    else return false;
    }
    public static void phanTich(int n){
        int i=2;
        System.out.print("Số "+ n +" sau khi được phân tích: n=");
        while(n>1){
            if(checkSNT(i)){
                if(n%i==0){
                    System.out.print(i+".");
                    n/=i;
                }
                else i++;
            }
            else i++;
        }
    }
    public static void lietKeUoc(int n){
        System.out.print("\nCac uoc cua "+n+" la:");
        for(int i=1 ; i<=n ; i++) {
            if (n % i == 0) {
                System.out.print(" " + i);
            }
        }
    }
    public static void lietKeUocSNT(int n) {
        System.out.print("\nCac uoc cua " + n + " la:");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && (checkSNT(i))) {
                System.out.print(" " + i);
            }
        }
    }
        public static void main(String[] args) {
        System.out.print("Nhập n:n=");
        int n= nhap();
        //System.out.print("n= 1" );
        //System.out.println("");
        System.out.println("Tổng các chữ số của "+n+" là: "+tongChuSo(n));
        phanTich(n);
        lietKeUoc(n); lietKeUocSNT(n);
    }
}
