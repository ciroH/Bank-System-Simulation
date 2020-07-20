
public class usuariosV2 {
	String cuenta,pass, nroCajaAhorro, nroCtaCte; //nroCajaAhorro y nroCtaCte son Strings, porque si fuesen unsigned int superarían el rango permitido dependiendo del valor que se le quisiese asignar a estas variables 
	private float SaldoCajaAhorro, SaldoCtaCte;  //se usó el modificador de acceso private pensando en proteger los datos sensibles de los usuarios
	
	usuariosV2(int cant){
		this.setPass("0000000"+cant);
		this.setCuenta("usuario_"+cant);
		this.setSaldoCajaAhorro((cant*10)+500);
		this.setSaldoCtaCte(cant*50);
		this.setNroCajaAhorro("11111-1111-111"+cant);
		this.setNroCtaCte("22222-2222-222"+cant);
	}
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNroCajaAhorro() {
		return nroCajaAhorro;
	}
	public void setNroCajaAhorro(String nroCajaAhorro) {
		this.nroCajaAhorro = nroCajaAhorro;
	}
	public String getNroCtaCte() {
		return nroCtaCte;
	}
	public void setNroCtaCte(String nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}
	public float getSaldoCajaAhorro() {
		return SaldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(float saldoCajaAhorro) {
		SaldoCajaAhorro = saldoCajaAhorro;
	}
	public float getSaldoCtaCte() {
		return SaldoCtaCte;
	}
	public void setSaldoCtaCte(float saldoCtaCte) {
		SaldoCtaCte = saldoCtaCte;
	}
	
}
