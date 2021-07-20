package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculadora {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea txtrValorConvertido = new JTextArea();
		txtrValorConvertido.setText("Valor convertido");
		txtrValorConvertido.setBounds(49, 125, 147, 85);
		panel.add(txtrValorConvertido);

		textField = new JTextField();
		textField.setBounds(27, 61, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Dolar");
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(292, 100, 109, 23);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Euro");
		rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_1.setBounds(292, 126, 109, 23);
		panel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Libra");
		rdbtnNewRadioButton_2.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_2.setBounds(292, 152, 109, 23);
		panel.add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel = new JLabel("Valor em Reais");
		lblNewLabel.setBounds(27, 36, 88, 14);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Converter");
		btnNewButton.setBackground(Color.white);
		btnNewButton.setBounds(314, 216, 89, 23);
		btnNewButton.addActionListener(event -> {
			ObterValorMoeda obterMoeda = new ObterValorMoeda();
			if (textField.getText() != null && !textField.getText().isEmpty()) {
				try {
					if (rdbtnNewRadioButton.isSelected()) {

						Double valor = Double.parseDouble(textField.getText());
						txtrValorConvertido.setText("R$" + obterMoeda.converterMoeda("dolar", valor).toString());
					} else if (rdbtnNewRadioButton_1.isSelected()) {
						Double valor = Double.parseDouble(textField.getText());
						txtrValorConvertido.setText("R$" + obterMoeda.converterMoeda("euro", valor).toString());

					} else if (rdbtnNewRadioButton_2.isSelected()) {
						Double valor = Double.parseDouble(textField.getText());
						txtrValorConvertido.setText("R$" + obterMoeda.converterMoeda("libra", valor).toString());

					} else {
						txtrValorConvertido.setText("Escolha uma opção.");

					}

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} else {
				txtrValorConvertido.setText("Digite um valor válido.");
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);

		panel.add(btnNewButton);

	}

}
