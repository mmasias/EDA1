class SvsSB {
    public static void main(String[] args) {
        
        String s = "";
        for (int i = 0; i < 10; i++) {
            s = s + "a";
            System.out.println("Agregando S...");
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("a");
            System.out.println("Agregando SB...");
        }
    }
}