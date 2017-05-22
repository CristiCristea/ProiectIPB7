package com.fiiLicence.fiiLicence.services.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccessBD{

	protected  int           idCont;
	protected  String        tip;
	protected  UserBD        user;
	protected  Connection    conexiune;
	
	public AccessBD(){
		
	}
	
	public void setTip( String tip ){
		this.tip = tip;
	}
	
	public String getTip(){
		return tip;
	}
	
	public void setIdCont( int idCont ){
		this.idCont = idCont;
	}
	
	public int getIdCont( int idCont ){
		return idCont;
	}
	
	public UserBD getUser(){
		return user;
	}

	@Override
	public String toString() {
		return "AccessBD [idCont=" + idCont + ", tip=" + tip + ", user=" + user + ", conexiune=" + conexiune + "]";
	}

	
	
       //------------------------------Secratary Rights------------------------------------
    
	
	public IntrareComisii getCommitteByProf(int idProf){
		 IntrareComisii intrare = new IntrareComisii();
			try{		
				
				PreparedStatement pStatement = conexiune.prepareStatement("select * from comisii c join profesori p on c.id = p.id_comisie where p.id = ?");
				pStatement.setInt(1, idProf);
				ResultSet result = pStatement.executeQuery(); 
				if(result.next()){
					
					intrare.setId(result.getInt(1));
					intrare.setIdProfSef(result.getInt(2));
					intrare.setIdProf2(result.getInt(3));
					intrare.setIdProf3(result.getInt(4));
					intrare.setIdProf4(result.getInt(5));
					intrare.setIdSecretar(result.getInt(6));
					intrare.setTipComisie(result.getString(7));
					intrare.setIdEvaluare(result.getInt(8));	
					
				}
				return intrare;
				
			}
			catch( SQLException e ){
				System.out.println("Exceptie la selectComisii: " + e.getMessage());
				return null;
			}
			
		}
	

	public IntrareComisii getCommitteByStudent(int idStudent){
		 IntrareComisii intrare = new IntrareComisii();
			try{		
				PreparedStatement pStatement = conexiune.prepareStatement("select * from comisii c join studenti s on c.id = s.id_comisie where s.id = ?");
				pStatement.setInt(1, idStudent);
				ResultSet result = pStatement.executeQuery(); 
				if(result.next() && result!=null){
					
					intrare.setId(result.getInt(1));
					intrare.setIdProfSef(result.getInt(2));
					intrare.setIdProf2(result.getInt(3));
					intrare.setIdProf3(result.getInt(4));
					intrare.setIdProf4(result.getInt(5));
					intrare.setIdSecretar(result.getInt(6));
					intrare.setTipComisie(result.getString(7));
					intrare.setIdEvaluare(result.getInt(8));	
						
				}
				return intrare;
				
			}
			catch( Exception e ){
				System.out.println("Exceptie la selectComisii: "+e.getMessage());
				return null;
			}
			
		}
	
	
	public IntrareComisii getCommitteeById(int idCommittee) {
        IntrareComisii rezultat = new IntrareComisii();
        try {
            PreparedStatement statement = conexiune.prepareStatement("Select * from comisii where id = ?");
            statement.setInt(1, idCommittee);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                rezultat.setId(result.getInt(1));
                rezultat.setIdProfSef(result.getInt(2));
                rezultat.setIdProf2(result.getInt(3));
                rezultat.setIdProf3(result.getInt(4));
                rezultat.setIdProf4(result.getInt(5));
                rezultat.setIdSecretar(result.getInt(6));
                rezultat.setTipComisie(result.getString(7));
                rezultat.setIdEvaluare(result.getInt(8));
            }
            return rezultat;
            
        } catch (SQLException e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        }

    }
	
	
	public IntrareProfesori getProfesorById(int idProf) {
		IntrareProfesori intrare = new IntrareProfesori();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from profesori"); 
			while(result.next()){
				
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNume(result.getString(3));
				intrare.setPrenume(result.getString(4));
				intrare.setGradDidactic(result.getString(5));
				intrare.setFunctieComisie(result.getString(6));
				
			}
			return intrare;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}		

    }
	
	
	public List<IntrareStudenti> getStudentsByCommitte(int idCommitte){
		List<IntrareStudenti> listaStudenti = new ArrayList<IntrareStudenti>();
		try{
				PreparedStatement statement=conexiune.prepareStatement("Select * from studenti where id_comisie = ?");
				statement.setInt(1,idCommitte);
				ResultSet result   =statement.executeQuery();
				
				while(result.next()){
					IntrareStudenti intrare = new IntrareStudenti();
					intrare.setId(result.getInt(1));
					intrare.setIdCont(result.getInt(2));
					intrare.setNrMatricol(result.getString(3));
					intrare.setNume(result.getString(4));
					intrare.setPrenume(result.getString(5));
					intrare.setId_comisie(result.getInt(6));
					intrare.setIdSesiune(result.getInt(7));
					listaStudenti.add(intrare);
				}
				return listaStudenti;
			}
			catch( Exception e ){
				System.out.println("Exceptie la selectStudenti:"+e.getMessage());
				return null;
			}		
	}
	
	//--------------------------------------------------------------------------------
	

	
	//---------------------------------Profesor Access------------------------
	
	public int getProfIndex(int idProf, int idCommitte){
		 
		 IntrareComisii rezultat = new IntrareComisii();
		try{
				PreparedStatement statement=conexiune.prepareStatement("Select * from comisii where id = ?");
				statement.setInt(1,idCommitte);
				ResultSet result   =statement.executeQuery();
				
				while(result.next()){

					rezultat.setId(result.getInt(1));
					rezultat.setIdProfSef(result.getInt(2));
					rezultat.setIdProf2(result.getInt(3));
					rezultat.setIdProf3(result.getInt(4));
					rezultat.setIdProf4(result.getInt(5));
					rezultat.setIdSecretar(result.getInt(6));
					rezultat.setTipComisie(result.getString(7));
					rezultat.setIdEvaluare(result.getInt(8));	
					
				}
				
			}
			catch( Exception e ){
				System.out.println("Exceptie la selectStudenti:"+e.getMessage());
				return 0;
			}	
		
		if(rezultat.getIdProfSef()==idProf){
			return 1;
		 }
		else if(rezultat.getIdProf2()==idProf){
			return 2;
		 }
		else if(rezultat.getIdProf3()==idProf){
			return 3;
		 }
		else if(rezultat.getIdProf4()==idProf){
			return 4;
		 }
		else 
			return 0;
		 
	}

	
	public boolean updateNotaStudent(int indexProf, int idStudent, int tipExamen,int notaOral, int notaProiect){
		if(tipExamen == 1 && (indexProf !=1 && indexProf !=2 && indexProf !=3 &&  indexProf !=5)){
			
			return false;
	
		}
		else if(tipExamen == 2 && (indexProf !=1 && indexProf !=2 && indexProf !=3 && indexProf !=4 && indexProf !=5)){
			
			return false;
		}
		
		try{
		PreparedStatement statement = conexiune.prepareStatement("Select id from licente where id_student = ?");
		statement.setInt(1,idStudent);
		ResultSet result =statement.executeQuery();
		result.next();
		

		int idLicenta = result.getInt(1);
		
		
		if(indexProf !=5 ){
			PreparedStatement statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_"+indexProf+"_oral = ?,nota_"+indexProf+"_proiect = ? where id = ? ");
			statement2.setInt(1,notaOral);
			statement2.setInt(2,notaProiect);
			statement2.setInt(3,idLicenta);
			statement2.executeUpdate();
			return true;
		}
		
		else {
			PreparedStatement statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_"+indexProf+"_oral_coordonator = ?,nota_"+indexProf+"_proiect_coordonator = ? where id = ? ");
			statement2.setInt(1,notaOral);
			statement2.setInt(2,notaProiect);
			statement2.setInt(3,idLicenta);
			statement2.executeUpdate();
			return true;
		}
		
		}
		catch( Exception e ){
			System.out.println("Exceptie la update nota:"+e.getMessage());
			return false;
		}	
		
		
	}
	

	public boolean moveProfToCommitte(int idProf, int idCommitte ){
	
		try{
		
			PreparedStatement statement = conexiune.prepareStatement(
					"UPDATE "+
					"(SELECT detalii_licente.id_comisie as COMISIE "+
					" FROM detalii_licente "+
					" INNER JOIN licente "+
					" ON detalii_licente.id = licente.id "+
					" WHERE licente.id_profesor=? "+
					") t "+
					"SET t.Comisie = ? ");
			statement.setInt(1,idProf);
			statement.setInt(2,idCommitte);
			statement.executeUpdate();
			return true;
		
		}
		catch( Exception e ){
			System.out.println("Exceptie la update comisieProf:"+e.getMessage());
			return false;
		}	
		
		
	}
	
	
}
