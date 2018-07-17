public class LOL {
    public static void main(String[] args) {
        Hero gailun = new Hero("gailun", 3000);
        Hero libai = new Hero("libai", 1500);

        libai.attack(gailun);
        gailun.attack(libai);

    }
}
