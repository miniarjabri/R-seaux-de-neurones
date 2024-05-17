package echantillon;

public class Xor {
private int sortie;

	
public  Xor (int entree1, int entree2)
{int [] coucheCachee = new int [2];
Ou neurone1=new Ou(entree1,entree2);
coucheCachee[0]=neurone1.getSortie();
Et x=new Et(entree1,entree2);
Non neurone2=new Non (x.getSortie()) ;
coucheCachee[1]=neurone2.getSortie();
Et neruonef=new Et (coucheCachee[0],coucheCachee[1] );
sortie=neruonef.getSortie();
}
public int getSortie ()
{return sortie;
}
}
