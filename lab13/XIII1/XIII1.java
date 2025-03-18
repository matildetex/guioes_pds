package lab13.XIII1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// Notas:
// Não altere o código apresentado na alinea 1
// Deve completar o código das alineas 2 e 3
// Pode comentar código para garantir que vai executando parcialmente

public class XIII1{

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("pds2022.txt"));
		test(System.out); // executa e escreve na consola
		fl.println(System.getProperty("user.dir"));
		fl.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		question1(out);
		question2(out);
		// question3(out);
	}

	private static void question1(PrintStream out) {
		out.println("\nQuestion 1) ----------------------------------\n");
		ToShare market = new ToShare();
		Product[] cars = {
			new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
			new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
			new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
			new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
		};
		for (Product item : cars) 
			market.add(item);

		out.println("--- All Products :");
		for (Product item : market.getProducts())
			out.println(item);		
	
		Client u1 = new Client("187", "Peter Pereira");
		Client u2 = new Client("957", "Anne Marques");
		Client u3 = new Client("826", "Mary Monteiro");
		market.share("ZA11ZB", u1);
		market.share(cars[2], u2);
		market.share("BB44ZB", u3);

		out.println("--- Shared Products :\n" + market.sharedProducts());
		market.giveBack(cars[0]);
		market.giveBack("BB44ZB");
		out.println("--- Shared Products :\n" + market.sharedProducts());
		
		market.remove("ZA11ZB");
		OldJeep oj = new OldJeep("JJ0011;Some old SUV;88.5"); // assume "code;description;points"
		market.add(new Jeep(oj));
		out.println("--- All Products :");
		for (Product item : market)
			out.println(item);	
	}

	private static void question2(PrintStream out) {
		out.println("\nQuestion 2 (output example) ----------------------------------\n");
		// Completar
		 // Testando com vetor de produtos
		 Product[] cars = {
            new Car("Toyota", "2022", 180),
            new Car("Ford", "2020", 200),
            new Car("BMW", "2021", 220)
        };
        ProductsReader vectorReader = new VectorProductsReader(cars);
        ToShare toShareVector = new ToShare();
        toShareVector.setProducts(vectorReader);
        System.out.println("Produtos do vetor:");
        for (Product p : toShareVector.getProducts()) {
            System.out.println(p);
        }

        // Testando com ficheiro TXT
        String filePath = "path/to/products.txt";
        ProductsReader txtReader = new TxtProductsReader(filePath);
        ToShare toShareTxt = new ToShare();
        toShareTxt.setProducts(txtReader);
        System.out.println("\nProdutos do ficheiro TXT:");
        for (Product p : toShareTxt.getProducts()) {
            System.out.println(p);
        }
    }
	

	private static void question3(PrintStream out) {
		out.println("\nQuestion 3) ----------------------------------\n");
		// Completar
		 // Criar instância de ToShare
		 ToShare shareIt = new ToShare();

		 // Adicionar produtos
		 Product car1 = new Car("UA0001", "Tesla Model 3, 2021", 100);
		 Product car2 = new Car("UA0002", "Ford Mustang, 2020", 120);
		 shareIt.add(car1);
		 shareIt.add(car2);
 
		 // Criar clientes
		 Client u1 = new Client("187", "Peter Pereira");
		 Client u2 = new Client("957", "Anne Marques");
		 Client u3 = new Client("826", "Mary Monteiro");
 
		 // Registrar clientes como observadores
		 shareIt.addObserver(u1);
		 shareIt.addObserver(u2);
		 shareIt.addObserver(u3);
 
		 // Emprestar produto para u1
		 shareIt.share("UA0001", u1);  // true
		 System.out.println("--- Shared Products :\n" + shareIt.sharedProducts());
 
		 // Tentar emprestar o mesmo produto para u2
		 boolean shared = shareIt.share("UA0001", u2);   // false (já está emprestada)
		 System.out.println("Share UA0001 to u2: " + shared);
		 
		 // Devolver produto por u1
		 shareIt.giveBack("UA0001");   // true (devolvida por u1, emprestado a u2)
		 System.out.println("--- Shared Products :\n" + shareIt.sharedProducts());
 
		 // Devolver produto por u2
		 shareIt.giveBack("UA0001");   // true (devolvida por u2)
		 System.out.println("--- Shared Products :\n" + shareIt.sharedProducts());
 
		 // Tentar devolver o produto novamente
		 boolean returned = shareIt.giveBack("UA0001");   // false
		 System.out.println("GiveBack UA0001 again: " + returned);
	 }
	}


}