package test;

public class Seller implements  Runnable {
private  int[] tickers;

    public Seller(int[] ticker) {
        this.tickers = ticker;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                sell(tickers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sell(int[] tickers) throws InterruptedException {
        synchronized (tickers){
        for (int i = tickers.length-1; i >-1; i--) {
          if (tickers[i]==0&&i!=0){
              continue;
          }
          if (tickers[i]==1){
              System.out.println("票仓有票，销售票"+i);
              tickers[i]= 0;
              if (i==tickers.length-1){
              tickers.notify();}
              return;
          }
          if (tickers[i]==0&&i==0){
              System.out.println("票仓没有票");
              tickers.wait();
          }
        }}
    }
}
