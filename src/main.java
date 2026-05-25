public class main {

    public static void main (String[] args) {
        SalesReader reader = new SalesReader("data/salgsstatistik.csv");

        reader.readFileAndParse();


        System.out.println("Dit samlede beløb af alt salg for året er " +reader.calculateTotal());


        System.out.println("Dit gennemsnit er " + reader.average());


        System.out.println("dit hæjste (max) salg er " + reader.max());
    }
}
