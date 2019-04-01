package it.polito.tdp.toto;

public class Espandi {

	//Livello della ricorsione = singola partita
	//Livello = 0 -> Schedina con 0 risultati
	//Livello = 1 -> Schedina con 1 risultato
	//Ecc ecc ecc...
	
	public void espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		espandi(p, parziale, 0);
	}
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		//Se parziale contiene già (livello) valori
		//nelle posizioni 0...(livello-1)
		//io devo determinare parziale[livello]--> (cioe' livello +1esima riga)
		//sulla base della previsione in p[livello]
		
		
		//CONDIZIONE DI FINE RICORSIONE ( cioè andare "fuori schedina" )
		if (livello==p.getN()) {
			System.out.println(parziale);
			return;
		};
		
	    Previsione prev = p.get(livello) ;
	    
	    //provo le varie alternative
	    for (Risultato r : prev.getValori()) {
	    	//provo ad aggiungere 'r' alla soluzione
	    	parziale.add(r);
	    	
	    	espandi(p, parziale, livello+1);
	    	
	    	// backtrack
	    	parziale.removeLast();
	    }
		
	}
	
	
	
	
	
	
	
}
