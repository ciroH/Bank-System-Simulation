import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
//import java.awt.Window;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.color.*;
import java.awt.Font;
import java.util.ArrayList;


public class terminalV2 extends JFrame implements ActionListener,ItemListener {
	
	JButton aceptar,borrar, salir,salirALogin,transferirYO,transferirEL,extraerDepositar;
	JLabel usuLabel,passLabel,saldoALabel,saldoCLabel,ctaALabel,ctaCLabel,menuLabel,montoLabel,chequeLabel,bankLogoLabel;
	JTextField usuField,montoField,chequeField;
	JPasswordField passField;
	JRadioButton radioCtaCte,radioCajaAhorro,radioSaldo,radioTransferencia,radioExtraccion,radioDepositoE,radioDepositoC;
	ImageIcon bankLogo, appIcon;
	static ArrayList<usuariosV2> userList;
	static int intentos = 3, pointer = -1,tercPointer = -1,isAhorroOrCte = 0, casoSw = 0, cant;
	static float  monto = 0;

	
	public static void main(String[] args) {
	 JFrame terminal = new terminalV2();
	String valueStr = "";
	 do { 
		 try { 
	 valueStr = ( JOptionPane.showInputDialog("Bienvenido a la demostración interactiva del Nuevo portal de Banco Banca Comercial S.A. \n Para su mayor comodidad, ingrese la cantidad de cuentas Demo con las que desea probar el sistema \n (debe ser igual o superior a 4):"));
	 if (valueStr == null) {
		System.exit(0);
	} else {
		cant = Integer.parseInt(valueStr);
	}
	 
	 if(cant<4) JOptionPane.showMessageDialog(null, "ingrese un valor de usuarios igual o mayor a 4");
	 
	 
		} catch(NumberFormatException numberFormatException) { 
			JOptionPane.showMessageDialog(null, "Porfavor, solo ingrese valores numéricos");
			cant = 0 ; 
			}
	 } while (cant < 4);
	userList = terminalV2.inicializa(cant);

	}
	
	terminalV2(){
		
		setTitle("Log-in");
		setLayout(null);
		setBounds(0, 0, 300, 252);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		aceptar = new JButton("Aceptar");
		borrar = new JButton("Borrar");
		salir = new JButton ("Salir");
		usuLabel = new JLabel ("usuario: ");
		passLabel = new JLabel ("contaseña: ");
		usuField = new JTextField();
		passField = new JPasswordField();
		
		bankLogo = new ImageIcon("imageResources/BankLogo_Rezised.png");
		appIcon = new ImageIcon("imageResources/BankT.png");
		bankLogoLabel = new JLabel(bankLogo);
		setIconImage(appIcon.getImage());
		
		add(aceptar);
		add(borrar);
		add(salir);
		add(usuLabel);
		add(passLabel);
		add(usuField);
		add(passField);							//1° añado, después Seteo los Bounds
		add(bankLogoLabel);
		
		usuLabel.setBounds(10, 0, 100, 30);
		passLabel.setBounds(10, 30, 100, 30);
		usuField.setBounds(100, 10, 100, 20);
		passField.setBounds(100, 40, 100, 20);
		aceptar.setBounds(41, 180, 100, 30);
		salir.setBounds(161, 180, 100, 30);
		borrar.setBounds(210, 10, 80, 50);
		bankLogoLabel.setBounds(0, 0, 300, 252);

		aceptar.addActionListener(this);
		borrar.addActionListener(this);
		salir.addActionListener(this);
		
		bankLogoLabel.setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent radioEvent) {
		if (radioCajaAhorro.isSelected() && radioSaldo.isSelected()) {
			limpiaMenu(0);
			ctaCLabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(true);
			saldoALabel.setVisible(true);
			
		}
		if (radioCtaCte.isSelected() && radioSaldo.isSelected()) {
			limpiaMenu(0);
			ctaCLabel.setVisible(true);
			saldoCLabel.setVisible(true);
			ctaALabel.setVisible(false);
			saldoALabel.setVisible(false);
		}
		if (radioCajaAhorro.isSelected() && radioTransferencia.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(true);
			saldoALabel.setVisible(true);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			transferirEL.setVisible(true);
			transferirYO.setVisible(true);
			transferirYO.setText("A Mi Cta. Cte.");
		}
		if (radioCtaCte.isSelected() && radioTransferencia.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(true);
			saldoCLabel.setVisible(true);
			ctaALabel.setVisible(false);
			saldoALabel.setVisible(false);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			transferirEL.setVisible(true);
			transferirYO.setVisible(true);
			transferirYO.setText("A Mi Caja Ahorro");
		}
		if (radioCajaAhorro.isSelected() && radioExtraccion.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(true);
			saldoALabel.setVisible(true);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Extraer");
			extraerDepositar.setVisible(true);
		}
		if (radioCtaCte.isSelected() && radioExtraccion.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(true);
			saldoCLabel.setVisible(true);
			ctaALabel.setVisible(false);
			saldoALabel.setVisible(false);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Extraer");
			extraerDepositar.setVisible(true);
		}
		if (radioCajaAhorro.isSelected() && radioDepositoE.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(true);
			saldoALabel.setVisible(true);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Depositar");
			extraerDepositar.setVisible(true);
		}
		if (radioCtaCte.isSelected() && radioDepositoE.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(true);
			saldoCLabel.setVisible(true);
			ctaALabel.setVisible(false);
			saldoALabel.setVisible(false);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Depositar");
			extraerDepositar.setVisible(true);
		}
		if (radioCajaAhorro.isSelected() && radioDepositoC.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(true);
			saldoALabel.setVisible(true);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Depositar");
			extraerDepositar.setVisible(true);
			chequeField.setVisible(true);
			chequeLabel.setVisible(true);
		}
		if (radioCtaCte.isSelected() && radioDepositoC.isSelected()) {
			limpiaMenu(0);
			
			ctaCLabel.setVisible(true);
			saldoCLabel.setVisible(true);
			ctaALabel.setVisible(false);
			saldoALabel.setVisible(false);
			
			montoLabel.setVisible(true);
			montoField.setVisible(true);
			extraerDepositar.setText("Depositar");
			extraerDepositar.setVisible(true);
			chequeLabel.setVisible(true);
			chequeField.setVisible(true);
		}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource() == aceptar) {
			String user = usuField.getText();
			char[] password = passField.getPassword();
			int arrayPointer = (-1);
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).cuenta.equals(user) && userList.get(i).pass.equals(String.valueOf(password))) {
					arrayPointer = i;
					JOptionPane.showMessageDialog(null, "Bienvenido"); 
					pointer = arrayPointer;
				}
			}
			if (arrayPointer == -1) {
				JOptionPane.showMessageDialog(null, "Cuenta o Contraseña son incorrectas");
				intentos -=1; 
				if (intentos < 1) {
					JOptionPane.showMessageDialog(null, "No posee más intentos, privilegios de cliente suspendidos");
					System.exit(0);
				}
			}
			else {
				limpia(true);
				logIn(arrayPointer);
			}
			
		}
		if (e.getSource() == borrar) {
			usuField.setText("");
			passField.setText("");
		}
		if (e.getSource() == salir) {
			System.exit(0);
		}
		if (e.getSource() == salirALogin) {
			limpiaMenu(1);
			limpia(false);
		}
		if (e.getSource() == transferirYO ) {   //cada uno de los if que verifica que radiobutton está seleccionado (cta cte o caja ahorro), debe también realizar un setVisible(false) en los elementos de la opcion seleccionada (transferencia, extraccion, etc)
			if (radioCajaAhorro.isSelected()==true ) { 
				//monto = Float.parseFloat(montoField.getText()); //float
				//userList.set(pointer,userList.get(pointer).getSaldoCajaAhorro()).setSaldoCajaAhorro();
				//userList.set(pointer, userList.get(pointer).getSaldoCtaCte()).setSaldoCajaAhorro();
				if ( montoField.getText().equals("") || Float.parseFloat(montoField.getText()) <= 0 || (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCajaAhorro())) {
					JOptionPane.showMessageDialog(null, "Porfavor, ingrese un monto válido");
					montoField.setText("");
				} else {
				terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) + Float.parseFloat(montoField.getText()));
				terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) - Float.parseFloat(montoField.getText()));
				saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
				saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente");
				}
			}
			else { //transferencia de Cta Cte de user a caja ahorro de user
				if (montoField.getText().equals("") || Float.parseFloat(montoField.getText()) <= 0 || (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCtaCte()) ) {
					JOptionPane.showMessageDialog(null, "Porfavor, ingrese un monto válido");
					montoField.setText("");
				} else {
				terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) - Float.parseFloat(montoField.getText()));
				terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) + Float.parseFloat(montoField.getText()));
				saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
				saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente");
						}
				}
		}
		if (e.getSource() == transferirEL) {  
			if (radioCajaAhorro.isSelected()==true ) { //transferencia de Caja ahorro de user a cuenta de tercero
				if (montoField.getText().equals("") || Float.parseFloat(montoField.getText()) <= 0 || (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCajaAhorro()) ) {
					JOptionPane.showMessageDialog(null, "Porfavor, ingrese un monto válido");
					montoField.setText("");
				} else {
					String nCuenta = JOptionPane.showInputDialog("Ingrese N° de cuenta:");
					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).getNroCajaAhorro().equals(nCuenta)) {
							tercPointer = i;
							isAhorroOrCte = 1;
							
						}
						if (userList.get(i).getNroCtaCte().equals(nCuenta)) {
							tercPointer = i;
							isAhorroOrCte = 2;
						}
					}
						if (tercPointer == -1) {
							JOptionPane.showMessageDialog(null, "Cuenta inexistente");
						} else {
							//verifico si es caja ahorro o cta cte del tercero y transfiero el monto
							terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) - Float.parseFloat(montoField.getText()));
							if( isAhorroOrCte == 1) {// si es true, la cuenta del tercero es una caja de ahorro
							terminalV2.userList.get(tercPointer).setSaldoCajaAhorro((terminalV2.userList.get(tercPointer).getSaldoCajaAhorro()) + Float.parseFloat(montoField.getText()));
							} else { //la cuenta del tercero es una cta cte
								terminalV2.userList.get(tercPointer).setSaldoCtaCte((terminalV2.userList.get(tercPointer).getSaldoCtaCte()) + Float.parseFloat(montoField.getText()));	
							}
							montoLabel.setText("");
							saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
							limpiaMenu(2);
							radioSaldo.setSelected(true);
							JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente");
						}
								
						}
			}
			else { 									//transferencia de Cta. Cte. de user a cuenta de tercero
				if (montoField.getText().equals("") || Float.parseFloat(montoField.getText()) <= 0 || (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCtaCte()) ) {
					JOptionPane.showMessageDialog(null, "Porfavor, ingrese un monto válido");
					montoField.setText("");
				} else {
					
					String nCuenta = JOptionPane.showInputDialog("Ingrese N° de cuenta:");
					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).getNroCajaAhorro().equals(nCuenta)) {
							tercPointer = i;
							isAhorroOrCte = 1;
							
						}
						if (userList.get(i).getNroCtaCte().equals(nCuenta)) {
							tercPointer = i;
							isAhorroOrCte = 2;
						}
					}
						if (tercPointer == -1) {
							JOptionPane.showMessageDialog(null, "Cuenta inexistente");
						} else {
							//verifico si es caja ahorro o cta cte del tercero y transfiero el monto
							terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) - Float.parseFloat(montoField.getText()));
							if( isAhorroOrCte == 1) {// si es true, la cuenta del tercero es una caja de ahorro
							terminalV2.userList.get(tercPointer).setSaldoCajaAhorro((terminalV2.userList.get(tercPointer).getSaldoCajaAhorro()) + Float.parseFloat(montoField.getText()));
							} else { //la cuenta del tercero es una cta cte
								terminalV2.userList.get(tercPointer).setSaldoCtaCte((terminalV2.userList.get(tercPointer).getSaldoCtaCte()) + Float.parseFloat(montoField.getText()));	
							}
							montoLabel.setText("");
							saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
							limpiaMenu(2);
							radioSaldo.setSelected(true);
							JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente");
						}
					/*"Bloque de código viejo" (Profe, ignore este comentario) */				
	}
			}
		}
		
							
		
		if (e.getSource() == extraerDepositar) {
			if (montoField.getText().equals("") || Float.parseFloat(montoField.getText()) <= 0 ) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a cero. no deje el campo del Monto Vacio");
					montoField.setText("");
					}else if (radioExtraccion.isSelected()== true && radioCajaAhorro.isSelected() == true && (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCajaAhorro())) {
						JOptionPane.showMessageDialog(null, "Ingrese un valor que no supere el de su Caja de Ahorro");
						montoField.setText("");
					
					}else if (radioExtraccion.isSelected() == true && radioCtaCte.isSelected() == true && (Float.parseFloat(montoField.getText()) > terminalV2.userList.get(pointer).getSaldoCtaCte())) {
						JOptionPane.showMessageDialog(null, "Ingrese un valor que no supere el de su Cuenta Corriente");
						montoField.setText("");
						
					}else if (radioCajaAhorro.isSelected() == true && radioExtraccion.isSelected() == true) {
							casoSw = 1;
					}else if (radioCtaCte.isSelected() == true && radioExtraccion.isSelected() == true) {
							casoSw = 2;
					}else if (radioCajaAhorro.isSelected() == true && radioDepositoE.isSelected() == true) {
							casoSw  = 3;
					}else if (radioCtaCte.isSelected() == true && radioDepositoE.isSelected() == true) {
							casoSw = 4;
					}else if (radioCajaAhorro.isSelected() == true && radioDepositoC.isSelected() == true) {
							casoSw = 5;
					}else if (radioCtaCte.isSelected() == true && radioDepositoC.isSelected() == true) {
							casoSw = 6;
					}					
			switch (casoSw) {
			case 1:
				terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) - Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Extracción realizada con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
				break;

			case 2:
				terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) - Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Extracción realizada con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
				break;
			case 3:
				terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) + Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Depósito realizado con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
				break;

			case 4:
				terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) + Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Depósito realizado con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
				break;
			case 5:
				if(chequeField.getText().equals("123456") && ((montoField.getText()).equals("150.50")||(montoField.getText()).equals("150.5"))) {
				terminalV2.userList.get(pointer).setSaldoCajaAhorro((terminalV2.userList.get(pointer).getSaldoCajaAhorro()) + Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Depósito realizado con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoALabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCajaAhorro()));
				} else {
					JOptionPane.showMessageDialog(null, "El N° de cheque o el Monto son incorrectos");
					montoField.setText("");
					chequeField.setText("");
				}
				break;

			case 6:
				if(chequeField.getText().equals("123456") && ((montoField.getText()).equals("150.50")||(montoField.getText()).equals("150.5"))) {
				terminalV2.userList.get(pointer).setSaldoCtaCte((terminalV2.userList.get(pointer).getSaldoCtaCte()) + Float.parseFloat(montoField.getText()));
				JOptionPane.showMessageDialog(null, "Depósito realizado con éxito");
				montoField.setText("");
				limpiaMenu(2);
				radioSaldo.setSelected(true);
				saldoCLabel.setText("Saldo: $" + String.valueOf(userList.get(pointer).getSaldoCtaCte()));
				} else {
					JOptionPane.showMessageDialog(null, "El N° de cheque o el Monto son incorrectos");
					montoField.setText("");
					chequeField.setText("");
				}
				break;
			}
		
		}
		} catch (NumberFormatException badNumber) {
			JOptionPane.showMessageDialog(null, "Solo debe ingresar valores numericos en el campo monto");
		}
	} 

	
	private void limpia(boolean Do) {
		setBounds(0, 0, 300, 252);
		setLocationRelativeTo(null);
		usuLabel.setVisible(!Do);
		passLabel.setVisible(!Do);
		usuField.setText("");
		usuField.setVisible(!Do);
		passField.setText("");
		passField.setVisible(!Do);
		aceptar.setVisible(!Do);
		salir.setVisible(!Do);
		borrar.setVisible(!Do); //se usó una variable envez de true o false porque se reutiliza la funcion al volver del menú a la pantalla de LogIn
		bankLogoLabel.setVisible(!Do);
		
	}
	
	private void limpiaMenu(int q) {
		if (q == 1) {
			//Limpio todos los RadioButton, el boton de salir, el Label de menú y los Labels de saldos y numeros de cuenta
			radioCajaAhorro.setVisible(false);
			radioCtaCte.setVisible(false);
			radioSaldo.setVisible(false);
			radioTransferencia.setVisible(false);
			radioExtraccion.setVisible(false);
			radioDepositoE.setVisible(false);
			radioDepositoC.setVisible(false);
			saldoALabel.setVisible(false);
			saldoCLabel.setVisible(false);
			ctaALabel.setVisible(false);
			ctaCLabel.setVisible(false);
			menuLabel.setVisible(false);
			salirALogin.setVisible(false);
		}
		//limpio los elementos de □ 
		montoLabel.setVisible(false);
		montoField.setVisible(false);
		transferirEL.setVisible(false);
		transferirYO.setVisible(false);
		extraerDepositar.setVisible(false);
		chequeField.setVisible(false);
		chequeLabel.setVisible(false);
		
	}

	private void logIn(int arrayPointer) {
		
		 radioCtaCte = new JRadioButton("Cuenta Corriente",false);
		 radioCajaAhorro = new JRadioButton("Caja de Ahorro",true);
		ButtonGroup cuentasRadioGroup = new ButtonGroup();
		cuentasRadioGroup.add(radioCajaAhorro);
		cuentasRadioGroup.add(radioCtaCte);
		
		 radioSaldo = new JRadioButton("Saldo",true);
		 radioTransferencia = new JRadioButton("Transferencia",false);
		 radioExtraccion = new JRadioButton("Extraccion",false);
		 radioDepositoE = new JRadioButton("Depósito en efectivo",false);
		 radioDepositoC = new JRadioButton("Depósito de cheques",false);
		ButtonGroup opcionesRadioGroup = new ButtonGroup();
		opcionesRadioGroup.add(radioSaldo);
		opcionesRadioGroup.add(radioTransferencia);
		opcionesRadioGroup.add(radioExtraccion);
		opcionesRadioGroup.add(radioDepositoE);
		opcionesRadioGroup.add(radioDepositoC);
		
		
		
		saldoALabel = new JLabel("Saldo: $" + String.valueOf(userList.get(arrayPointer).getSaldoCajaAhorro()));
		saldoCLabel = new JLabel("Saldo: $" + String.valueOf(userList.get(arrayPointer).getSaldoCtaCte()));
		ctaALabel = new JLabel("Información de la Cta. N°" + String.valueOf(userList.get(arrayPointer).getNroCajaAhorro()));
		ctaCLabel = new JLabel("Información de la Cta. N°" + String.valueOf(userList.get(arrayPointer).getNroCtaCte()));
		menuLabel = new JLabel("Menú Cuentas");
		montoLabel = new JLabel("Ingrese Monto: ");
		montoField = new JTextField();
		chequeLabel = new JLabel("N°Cheque:");
		chequeField = new JTextField();
		
		setLayout(null);
		//setBounds(0, 0, 750, 300);
		setSize(750,300);
		setLocationRelativeTo(null);
		setTitle("Bienvenido");		
		
		add(menuLabel);
		add(radioCajaAhorro);
		add(radioCtaCte);
		add(radioSaldo);
		add(radioTransferencia);
		add(radioExtraccion);
		add(radioDepositoE);
		add(radioDepositoC);
		add(saldoALabel);
		add(saldoCLabel);
		add(ctaALabel);
		add(ctaCLabel);
		add(montoLabel);
		add(montoField);
		add(chequeLabel);
		add(chequeField);
		
		menuLabel.setBounds(0, 0, 150, 20);
		menuLabel.setOpaque(true);
		menuLabel.setBackground(Color.RED);
		menuLabel.setForeground(Color.WHITE);
		radioCajaAhorro.setBounds(0, 21, 150, 30);
		radioCajaAhorro.setOpaque(true);
		radioCajaAhorro.setBackground(Color.GRAY);
		radioCtaCte.setBounds(0, 52, 150, 30);
		radioCtaCte.setOpaque(true);
		radioCtaCte.setBackground(Color.GRAY);
		radioSaldo.setBounds(0, 90, 150, 30);
		radioSaldo.setOpaque(true);
		radioSaldo.setBackground(Color.GRAY);
		radioTransferencia.setBounds(0, 121, 150, 30);
		radioTransferencia.setOpaque(true);
		radioTransferencia.setBackground(Color.GRAY);
		radioExtraccion.setBounds(0, 152, 150, 30);
		radioExtraccion.setOpaque(true);
		radioExtraccion.setBackground(Color.GRAY);
		radioDepositoE.setBounds(0, 183, 150, 30);
		radioDepositoE.setOpaque(true);
		radioDepositoE.setBackground(Color.GRAY);
		radioDepositoC.setBounds(0, 214, 150, 30);
		radioDepositoC.setOpaque(true);
		radioDepositoC.setBackground(Color.GRAY);
		
		radioCajaAhorro.addItemListener(this);
		radioCtaCte.addItemListener(this);
		radioSaldo.addItemListener(this);
		radioTransferencia.addItemListener(this);
		radioExtraccion.addItemListener(this);
		radioDepositoE.addItemListener(this);
		radioDepositoC.addItemListener(this);
		
		ctaALabel.setBounds(200, 21, 300, 20);
		ctaCLabel.setBounds(200, 21, 300, 20);
		saldoALabel.setBounds(200, 52, 300, 20);
		saldoCLabel.setBounds(200, 52, 300, 20);
		montoLabel.setBounds(200, 90, 150, 30);
		montoField.setBounds(350, 90, 100, 30);
		chequeLabel.setBounds(450, 90, 100, 30);
		chequeField.setBounds(550, 90, 100, 30);
		
		ctaALabel.setForeground(Color.RED);
		ctaCLabel.setForeground(Color.RED);
		ctaCLabel.setVisible(false);
		saldoALabel.setForeground(Color.RED);
		saldoCLabel.setForeground(Color.RED);
		saldoCLabel.setVisible(false);
		montoLabel.setVisible(false);
		montoField.setVisible(false);
		//transferirYO.setVisible(false);    			
		//transferirEL.setVisible(false);	 			
		//extraerDepositar.setVisible(false);			
		chequeLabel.setVisible(false);
		chequeField.setVisible(false);
		
		
		salirALogin = new JButton("Salir");
		add(salirALogin);
		salirALogin.setBounds(0, 250, 100, 20);
		salirALogin.addActionListener(this);
		transferirYO = new JButton("_");
		transferirYO.setFont(new Font("Arial", Font.PLAIN, 9));
		transferirEL = new JButton("Transferir a Cuenta");
		transferirEL.setFont(new Font("Arial", Font.PLAIN, 9));
		extraerDepositar = new JButton("_");
		extraerDepositar.setFont(new Font("Arial", Font.PLAIN, 9));
		add(transferirYO);
		add(transferirEL);
		add(extraerDepositar);
		transferirYO.setBounds(200, 121, 150, 30);
		transferirEL.setBounds(351, 121, 150, 30);
		extraerDepositar.setBounds(351, 121, 100, 30);
		transferirYO.addActionListener(this);
		transferirEL.addActionListener(this);
		extraerDepositar.addActionListener(this);
		transferirYO.setVisible(false);
		transferirEL.setVisible(false);
		extraerDepositar.setVisible(false);

					}

	public static ArrayList<usuariosV2> inicializa(int cant) {
		
		ArrayList<usuariosV2> userList = new ArrayList<>();
		for (int i = 0; i < cant; i++) {
			userList.add(new usuariosV2(i));
		}
		
		return userList;
	}
}

