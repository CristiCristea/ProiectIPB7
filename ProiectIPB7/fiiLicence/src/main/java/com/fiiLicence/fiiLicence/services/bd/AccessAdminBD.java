package com.fiiLicence.fiiLicence.services.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccessAdminBD extends AccessBD {

	AccessAdminBD( Connection conexiune , UserBD user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Admin";
		this.user = user;
	}
	
	public List<IntrareMesaje> selectMesaje(){
		List<IntrareMesaje> rezultat = new ArrayList<IntrareMesaje>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from mesaje"); 
			while(result.next()){
				IntrareMesaje intrare = new IntrareMesaje();
				intrare.setId(result.getInt(1));
				intrare.setIdEmitator(result.getInt(2));
				intrare.setIdDestinatar(result.getInt(3));
				intrare.setMesaj(result.getString(4));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectMesaje: "+e.getMessage());
			return null;
		}
		
	}

	public List<IntrareConturi> selectConturi(){
		List<IntrareConturi> rezultat = new ArrayList<IntrareConturi>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from conturi"); 
			while(result.next()){
				IntrareConturi intrare = new IntrareConturi();
				intrare.setId(result.getInt(1));
				intrare.setUsername(result.getString(2));
				intrare.setHashparola(result.getString(3));
				intrare.setEmail(result.getString(4));
				intrare.setTipUtilizator(result.getString(5));
				intrare.setStatus(result.getInt(6));
				intrare.setCodActivare(result.getString(7));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectConturi :"+e.getMessage());
			return null;
		}
	}

	public List<IntrareStudenti> selectStudenti(){
		List<IntrareStudenti> rezultat = new ArrayList<IntrareStudenti>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from studenti"); 
			while(result.next()){
				IntrareStudenti intrare = new IntrareStudenti();
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNrMatricol(result.getString(3));
				intrare.setNume(result.getString(4));
				intrare.setPrenume(result.getString(5));
				intrare.setIdSesiune(result.getInt(6));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectStudenti:"+e.getMessage());
			return null;
		}		
	}

	public List<IntrareProfesori> selectProfesori(){
		List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from profesori"); 
			while(result.next()){
				IntrareProfesori intrare = new IntrareProfesori();
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNume(result.getString(3));
				intrare.setPrenume(result.getString(4));
				intrare.setGradDidactic(result.getString(5));
				intrare.setFunctieComisie(result.getString(6));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}		
	}
	
	
	public List<IntrareComisii> selectComisii(){
		List<IntrareComisii> rezultat = new ArrayList<IntrareComisii>();
		try{
			
			PreparedStatement pStatement = conexiune.prepareStatement("SELECT * FROM comisii c join evaluari e on c.id = e.id_comisie");
			ResultSet result = pStatement.executeQuery(); 
			while(result.next() ){
				IntrareComisii intrare = new IntrareComisii();
				intrare.setId(result.getInt(1));
				intrare.setIdProfSef(result.getInt(2));
				intrare.setIdProf2(result.getInt(3));
				intrare.setIdProf3(result.getInt(4));
				intrare.setIdProf4(result.getInt(5));
				intrare.setIdSecretar(result.getInt(6));
				intrare.setTipComisie(result.getString(7));
				intrare.setIdEvaluare(result.getInt(8));
				intrare.setDataEvaluare(result.getString(12) + " ---> " + result.getString(13));
				
			
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectComisii: "+e.getMessage());
			return null;
		}
	}

	public List<IntrareEvaluari> selectEvaluari(){
		List<IntrareEvaluari> rezultat = new ArrayList<IntrareEvaluari>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from evaluari"); 
			while(result.next()){
				IntrareEvaluari intrare = new IntrareEvaluari();
				intrare.setId(result.getInt(1));
				intrare.setIdSesiune(result.getInt(2));
				intrare.setIdComisie(result.getInt(3));
				intrare.setInceputEvaluare(result.getTimestamp(4));
				intrare.setSfarsitEvaluare(result.getTimestamp(5));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectEvaluari: "+e.getMessage());
			return null;
		}
	}
	
	public List<IntrareDetaliiLicente> selectDetaliiLicente(){
		List<IntrareDetaliiLicente> rezultat = new ArrayList<IntrareDetaliiLicente>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from detalii_licente"); 
			while(result.next()){
				IntrareDetaliiLicente intrare = new IntrareDetaliiLicente();
				intrare.setId(result.getInt(1));
				intrare.setIdComisie(result.getInt(2));
				intrare.setNota1Oral(result.getInt(3));
				intrare.setNota1Proiect(result.getInt(4));
				intrare.setNota2Oral(result.getInt(5));
				intrare.setNota2Proiect(result.getInt(6));
				intrare.setNota3Oral(result.getInt(7));
				intrare.setNota3Proiect(result.getInt(8));
				intrare.setNota4Oral(result.getInt(9));
				intrare.setNota4Proiect(result.getInt(10));
				intrare.setDataOraSustinerii(result.getTimestamp(11));
				
				rezultat.add(intrare);
			}
			
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectDetaliiLicente: "+e.getMessage());
			return null;
		}
	}
	
	public List<IntrareLicente> selectLicente(){
		List<IntrareLicente> rezultat = new ArrayList<IntrareLicente>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from licente"); 
			while(result.next()){
				IntrareLicente intrare = new IntrareLicente();
				intrare.setId(result.getInt(1));
				intrare.setTitlu(result.getString(2));
				intrare.setIdProfesor(result.getInt(3));
				intrare.setIdStudent(result.getInt(4));
				intrare.setMaterialeLicenta(result.getString(5));
				intrare.setIdSesiune(result.getInt(6));
				intrare.setTipLucrare(result.getString(7));
				
				rezultat.add(intrare);
			}
			
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectLicente: "+e.getMessage());
			return null;
		}
	}
	
	public List<IntrareSesiuni> selectSesiuni(){
		List<IntrareSesiuni> rezultat = new ArrayList<IntrareSesiuni>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from sesiuni"); 
			while(result.next()){
				IntrareSesiuni intrare = new IntrareSesiuni();
				intrare.setId(result.getInt(1));
				intrare.setInceputSesiune(result.getTimestamp(2));
				intrare.setSfarsitSesiune(result.getTimestamp(3));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectSesiuni: "+e.getMessage());
			return null;
		}	
	}
	
	public int updateMesaj( IntrareMesaje intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Mesaje set iD_Emitator = ? , ID_Destinatar = ? , Mesaj = ? where id = ? ";
		try{
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from mesaje where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdEmitator());
			statement.setInt(2, intrare.getIdDestinatar());
			statement.setString(3, intrare.getMesaj());
			statement.setInt(4, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}

	public int updateCont( IntrareConturi intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Conturi set USERNAME = ? , PAROLA = ? , EMAIL = ? ,  TIP_UTILIZATOR=? , STATUS=? ,COD_ACTIVARE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from conturi where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, intrare.getUsername());
			statement.setString(2,intrare.getHashparola());
			statement.setString(3, intrare.getEmail());
			statement.setString(4,intrare.getTipUtilizator());
			statement.setInt(5, intrare.getStatus());
			statement.setString(6,intrare.getCodActivare());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}

	public int updateStudent( IntrareStudenti intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update studenti set ID_CONT = ? , NR_MATRICOL = ? , NUME = ? ,  PRENUME=? , ID_SESIUNE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from studenti where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdCont());
			statement.setString(2, intrare.getNrMatricol());
			statement.setString(3, intrare.getNume());
			statement.setString(4, intrare.getPrenume());
			statement.setInt(5, intrare.getIdSesiune());
			statement.setInt(6, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateStudent" + e.getMessage());
			return -7;
		}	
	}
	
	public int updateProfesor( IntrareProfesori intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update profesori set ID_CONT = ? ,NUME = ? ,  PRENUME=? ,GRAD_DIDACTIC=?,ID_COMISIE=?,FUNCTIE_COMISIE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from profesori where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1,intrare.getIdCont());
			statement.setString(2, intrare.getNume());
			statement.setString(3, intrare.getPrenume());
			statement.setString(4,intrare.getGradDidactic());
			statement.setInt(5, intrare.getIdComisie());
			statement.setString(6, intrare.getFunctieComisie());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateProfesor" + e.getMessage());
			return -7;
		}	
		
	}

	public int updateComisie( IntrareComisii intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update comisii set ID_Prof1 = ? , ID_Prof2 = ? , ID_Prof3 =?, ID_Prof4_Dizertatie = ?, ID_Secretar = ?, Tip_Comisie = ?, ID_Evaluare = ? where id = ? ";
		try{
	
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from comisii where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdProfSef());
			statement.setInt(2, intrare.getIdProf2());
			statement.setInt(3, intrare.getIdProf3());
			statement.setInt(4, intrare.getIdProf4());
			statement.setInt(5, intrare.getIdSecretar());
			statement.setString(6, intrare.getTipComisie());
			statement.setInt(7, intrare.getIdEvaluare());
			statement.setInt(8, intrare.getId());
			statement.executeUpdate();	
			conexiune.commit();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateComisie" + e.getMessage());
			return -7;
		}
		
	}
	
	public int updateEvaluare( IntrareEvaluari intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update evaluari set id_sesiune = ?, id_comisie = ?, inceput_evaluare = ?, sfarsit_evaluare = ? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from evaluari where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdSesiune());
			statement.setInt(2, intrare.getIdComisie());
			statement.setTimestamp(3, intrare.getInceputEvaluare());
			statement.setTimestamp(4, intrare.getSfarsitEvaluare());
			statement.setInt(5, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateEvaluare" + e.getMessage());
			return -7;
		}	
	}
	
	public int updateDetaliiLicenta( IntrareDetaliiLicente intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update detalii_licente set id_comisie = ?, nota_1_oral = ?, nota_1_proiect = ?, nota_2_oral = ?, nota_2_proiect = ?, nota_3_oral = ?, nota_3_proiect = ?, nota_4_oral_dizertatie = ?, nota_4_proiect_dizertatie = ?, data_ora_sustinere = ? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from detalii_licente where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdComisie());
			statement.setInt(2, intrare.getNota1Oral());
			statement.setInt(3, intrare.getNota1Proiect());
			statement.setInt(4, intrare.getNota2Oral());
			statement.setInt(5, intrare.getNota2Proiect());
			statement.setInt(6, intrare.getNota3Oral());
			statement.setInt(7, intrare.getNota3Proiect());
			statement.setInt(8, intrare.getNota4Oral());
			statement.setInt(9, intrare.getNota4Proiect());
			statement.setTimestamp(10, intrare.getDataOraSustinerii());
			statement.setInt(11, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateDetaliiLicenta" + e.getMessage());
			return -7;
		}	
		
	}
	
	public int updateLicenta( IntrareLicente intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update licente set titlu = ?, id_profesor = ?, id_student = ?, materiale_licenta = ?, id_sesiune = ?, tip = ? where id = ? ";
		try{			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from licente where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, intrare.getTitlu());
			statement.setInt(2, intrare.getIdProfesor());
			statement.setInt(3, intrare.getIdStudent());
			statement.setString(4, intrare.getMaterialeLicenta());
			statement.setInt(5, intrare.getIdSesiune());
			statement.setString(6, intrare.getTipLucrare());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateLicenta" + e.getMessage());
			return -7;
		}	
		
	}
	
	public int updateSesiune( IntrareSesiuni intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update sesiuni set inceput_sesiune = ?, sfarsit_sesiune = ? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from sesiuni where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setTimestamp(1, intrare.getInceputSesiune());
			statement.setTimestamp(2, intrare.getSfarsitSesiune());
			statement.setInt(3, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateSesiune" + e.getMessage());
			return -7;
		}	
		
	}
	
	public int insertMesaj( IntrareMesaje intrare ){
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Mesaje Values(Mesaje_SEQ.NEXTVAL, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getIdEmitator());
				statement.setInt(2, intrare.getIdDestinatar());
				statement.setString(3, intrare.getMesaj());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select MESAJE_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from MESAJE where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Mesaje Values(?, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2, intrare.getIdEmitator());
				statement.setInt(3, intrare.getIdDestinatar());
				statement.setString(4, intrare.getMesaj());
				statement.executeUpdate();
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertMesaj: "+e.getMessage());
			return -7;
		}
	}

	public int insertCont( IntrareConturi intrare){
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Conturi Values(CONTURI_SEQ.NEXTVAL, ?, ? ,?, ?, ? , ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setString(1, intrare.getUsername());
				statement.setString(2, intrare.getHashparola());
				statement.setString(3, intrare.getEmail());
				statement.setString(4, intrare.getTipUtilizator());	
				statement.setInt(5, intrare.getStatus());
				statement.setString(6, intrare.getCodActivare());
				statement.executeUpdate();
				
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select CONTURI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from CONTURI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Conturi Values(? , ?, ? ,?, ?, ? , ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setString(2, intrare.getUsername());
				statement.setString(3, intrare.getHashparola());
				statement.setString(4, intrare.getEmail());
				statement.setString(5, intrare.getTipUtilizator());
				statement.setInt(6, intrare.getStatus());
				statement.setString(7, intrare.getCodActivare());
				statement.executeUpdate();
				
				
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertCont: "+e.getMessage());
			return -7;
		}		
	}
	
	public int insertStudent( IntrareStudenti intrare){
		
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into STUDENTI Values(STUDENTI_SEQ.NEXTVAL, ?, ? ,?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdCont());
				statement.setString(2,intrare.getNrMatricol());
				statement.setString(3,intrare.getNume());
				statement.setString(4,intrare.getPrenume());
				statement.setInt(5,intrare.getIdSesiune());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select STUDENTI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from STUDENTI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Studenti Values(?, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdCont());
				statement.setString(3,intrare.getNrMatricol());
				statement.setString(4,intrare.getNume());
				statement.setString(5,intrare.getPrenume());
				statement.setInt(6,intrare.getIdSesiune());
				statement.executeUpdate();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertStudent: "+e.getMessage());
			return -7;
		}		
		
	}
	
	public int insertProfesor( IntrareProfesori intrare){
		
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Profesori Values(PROFESORI_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdCont());
				statement.setString(2, intrare.getNume());
				statement.setString(3, intrare.getPrenume());
				statement.setString(4, intrare.getGradDidactic());
				statement.setInt(5,intrare.getIdComisie());
				statement.setString(6,intrare.getFunctieComisie());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select PROFESORI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from PROFESORI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
		
				apel = " Insert into Profesori Values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdCont());
				statement.setString(3, intrare.getNume());
				statement.setString(4, intrare.getPrenume());
				statement.setString(5, intrare.getGradDidactic());
				statement.setInt(6,intrare.getIdComisie());
				statement.setString(7,intrare.getFunctieComisie());
				
				statement.executeUpdate();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertProfesori: "+e.getMessage());
			return -7;
		}		
		
	}
	
	public int insertComisie( IntrareComisii intrare){
		
		String apel = new String();	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Comisii (ID, ID_Prof1, ID_Prof2, ID_Prof3, ID_Prof4_Dizertatie, ID_Secretar, Tip_Comisie, ID_Evaluare) Values(to_number(COMISII_SEQ.NEXTVAL), ?, ? ,?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdProfSef());
				statement.setInt(2,intrare.getIdProf2());
				statement.setInt(3,intrare.getIdProf3());
				statement.setInt(4,intrare.getIdProf4());
				statement.setInt(5,intrare.getIdSecretar());
				statement.setString(6, intrare.getTipComisie());
				statement.setInt(7, intrare.getIdEvaluare());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select COMISII_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from COMISII where id = "+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Comisii Values(?, ?, ?, ? ,?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdProfSef());
				statement.setInt(3, intrare.getIdProf2());
				statement.setInt(4,intrare.getIdProf3());
				statement.setInt(5,intrare.getIdProf4());
				statement.setInt(6,intrare.getIdSecretar());
				statement.setString(7,intrare.getTipComisie());
				statement.setInt(8, intrare.getIdEvaluare());
				statement.executeUpdate();
				conexiune.commit();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertComisie: "+e.getMessage());
			return -7;
		}		
		
	}

	public int insertEvaluare( IntrareEvaluari intrare ){
	String apel;	
	try{
		if(intrare.getId()==0){
			apel = " Insert into Evaluari Values(Evaluari_SEQ.NEXTVAL, ?, ? ,?, ?)";
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdSesiune());
			statement.setInt(2, intrare.getIdComisie());
			statement.setTimestamp(3, intrare.getInceputEvaluare());
			statement.setTimestamp(4, intrare.getSfarsitEvaluare());
			statement.executeUpdate();
			conexiune.commit();
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select EVALUARI_SEQ.CURRVAL from dual");
			rs.next();
			intrare.setId(rs.getInt(1));
			
			return 0;
		}
		else{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Evaluari where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) > 0 ) {
				System.out.println("Intrare Existenta. Update?");
				return -1;
			}
			
			apel = " Insert into Evaluari Values(?, ?, ?, ? ,?)";
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1,intrare.getId());
			statement.setInt(2, intrare.getIdSesiune());
			statement.setInt(3, intrare.getIdComisie());
			statement.setTimestamp(4, intrare.getInceputEvaluare());
			statement.setTimestamp(5, intrare.getSfarsitEvaluare());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
	}
	catch( Exception e ){
		System.out.println("Exceptie la insertEvaluare: "+e.getMessage());
		return -7;
	}
  }
  
	public int insertDetaliiLicenta( IntrareDetaliiLicente intrare ){
		String apel = new String();	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Detalii_licente Values(Detalii_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getIdComisie());
				statement.setInt(2, intrare.getNota1Oral());
				statement.setInt(3, intrare.getNota1Proiect());
				statement.setInt(4, intrare.getNota2Oral());
				statement.setInt(5, intrare.getNota2Proiect());
				statement.setInt(6, intrare.getNota3Oral());
				statement.setInt(7, intrare.getNota3Proiect());
				statement.setInt(8, intrare.getNota4Oral());
				statement.setInt(9, intrare.getNota4Proiect());
				statement.setTimestamp(10, intrare.getDataOraSustinerii());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Detalii_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from detalii_licente where id = "+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into detalii_licente Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getId());
				statement.setInt(2, intrare.getIdComisie());
				statement.setInt(3, intrare.getNota1Oral());
				statement.setInt(4, intrare.getNota1Proiect());
				statement.setInt(5, intrare.getNota2Oral());
				statement.setInt(6, intrare.getNota2Proiect());
				statement.setInt(7, intrare.getNota3Oral());
				statement.setInt(8, intrare.getNota3Proiect());
				statement.setInt(9, intrare.getNota4Oral());
				statement.setInt(10, intrare.getNota4Proiect());
				statement.setTimestamp(11, intrare.getDataOraSustinerii());
				statement.executeUpdate();
				conexiune.commit();
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertDetaliiLicente: "+e.getMessage());
			return -7;
		}
	}
    
	public int insertLicenta( IntrareLicente intrare ){
		String apel;	
		try{
			if(intrare.getId()==0){
				apel = " Insert into Licente Values(Licente_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setString(1, intrare.getTitlu());
				statement.setInt(2, intrare.getIdProfesor());
				statement.setInt(3, intrare.getIdStudent());
				statement.setString(4, intrare.getMaterialeLicenta());
				statement.setInt(5, intrare.getIdSesiune());
				statement.setString(6, intrare.getTipLucrare());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select LICENTE_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from LICENTE where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into LICENTE Values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setString(2, intrare.getTitlu());
				statement.setInt(3, intrare.getIdProfesor());
				statement.setInt(4, intrare.getIdStudent());
				statement.setString(5, intrare.getMaterialeLicenta());
				statement.setInt(6, intrare.getIdSesiune());
				statement.setString(7, intrare.getTipLucrare());
				statement.executeUpdate();
				conexiune.commit();
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertLicenta: "+e.getMessage());
			return -7;
		}
	}
  
	public int insertSesiune( IntrareSesiuni intrare ){
		String apel;	
		try{
			if(intrare.getId()==0){
				apel = " Insert into sesiuni Values(SESIUNI_SEQ.NEXTVAL, ?, ? )";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setTimestamp(1, intrare.getInceputSesiune());
				statement.setTimestamp(2, intrare.getSfarsitSesiune());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Sesiuni_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from SESIUNI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into SESIUNI Values(?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setTimestamp(2, intrare.getInceputSesiune());
				statement.setTimestamp(3, intrare.getSfarsitSesiune());
				statement.executeUpdate();
				conexiune.commit();
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertSesiune: "+e.getMessage());
			return -7;
		}
	}
    
	public int dropMesaj( IntrareMesaje intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from mesaje where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Mesaje where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropMesaj:" + e.getMessage());
			return -7;
		}
	}

	public int dropCont( IntrareConturi intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Conturi where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Conturi where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropCont:" + e.getMessage());
			return -7;
		}
	}
	
	public int dropStudent( IntrareStudenti intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Studenti where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Studenti where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropStudent:" + e.getMessage());
			return -7;
		}
	}

	public int dropProfesor( IntrareProfesori intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Profesori where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Profesori where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropProfesor:" + e.getMessage());
			return -7;
		}
	}
    
    public int dropComisie( IntrareComisii intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Comisii where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Comisii where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropComisie:" + e.getMessage());
			return -7;
		}
	}
 
    public int dropEvaluare( IntrareEvaluari intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from evaluari where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from EVALUARI where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropEvaluari:" + e.getMessage());
			return -7;
		}
	}
    
    public int dropDetaliiLicenta( IntrareDetaliiLicente intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from DETALII_LICENTE where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from DETALII_LICENTE where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropDetaliiLicenta:" + e.getMessage());
			return -7;
		}
	}
    
    public int dropLicenta( IntrareLicente intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from LICENTE where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from LICENTE where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropLicenta:" + e.getMessage());
			return -7;
		}
	}
    
    public int dropSesiune( IntrareSesiuni intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Sesiuni where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from SESIUNI where id ="+intrare.getId());
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropSesiune:" + e.getMessage());
			return -7;
		}
	}
    
}
