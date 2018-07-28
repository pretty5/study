package test;

public class Producer implements Runnable {
private  int[] tickers;

    public Producer(int[] ticker) {
        this.tickers = ticker;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producer(tickers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void producer(int[] tickers) throws InterruptedException {
        synchronized (tickers){
        for (int i = 0; i < tickers.length; i++) {
            if (i == tickers.length-1  && tickers[i] == 1) {
                System.out.println("票仓已满，等待销售");
                tickers.wait();
            }
            if (tickers[i] == 1) {
                continue;
            } else {
                tickers[i] = 1;
                System.out.println("生产一张票" + i);
                if (i==0) {
                    tickers.notify();
                }
                return;
            }
        }

        }
        }
    }

