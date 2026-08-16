package projeto.compilador.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

import projeto.compilador.utils.NumberedBorder;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea editorCodigo;
	private JLabel lblStatusInfo;
	private JTextArea areaMensagens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		
		setTitle("Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1500, 800);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout()); 

		JPanel barraFerramentas = new JPanel();
		barraFerramentas.setPreferredSize(new Dimension(150, 0));
		barraFerramentas.setBackground(new Color(230, 230, 230));
		barraFerramentas.setLayout(new GridLayout(8, 1, 0, 0));
		barraFerramentas.setBorder(BorderFactory.createEtchedBorder());

		getContentPane().add(barraFerramentas, BorderLayout.WEST);
		JButton btnNovo = new JButton("Novo [ctrl-n]");
		barraFerramentas.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/new-document.png")));
		JButton btnAbrir = new JButton("Abrir [ctrl-o]");
		barraFerramentas.add(btnAbrir);
		btnAbrir.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/open-folder.png")));
		JButton btnSalvar = new JButton("Salvar [ctrl-s]");
		barraFerramentas.add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/save.png")));
		JButton btnCopiar = new JButton("Copiar [ctrl-c]");
		barraFerramentas.add(btnCopiar);
		btnCopiar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/copy.png")));
		JButton btnColar = new JButton("Colar [ctrl-v]");
		barraFerramentas.add(btnColar);
		btnColar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/paste.png")));
		JButton btnRecortar = new JButton("Recortar [ctrl-x]");
		barraFerramentas.add(btnRecortar);
		btnRecortar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/scissor.png")));
		JButton btnCompilar = new JButton("Compilar [F7]");
		barraFerramentas.add(btnCompilar);
		btnCompilar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/start.png")));
		JButton btnEquipe = new JButton("Equipe [F1]");
		barraFerramentas.add(btnEquipe);
		btnEquipe.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/team.png")));
	
		editorCodigo = new JTextArea();
		editorCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		editorCodigo.setBorder(new NumberedBorder());
		editorCodigo.setLineWrap(false);
		editorCodigo.setWrapStyleWord(false);
		JScrollPane scrollEditor = new JScrollPane(
			    editorCodigo, 
			    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
			);
		;
		scrollEditor.setBorder(BorderFactory.createTitledBorder(" Editor de Código-Fonte "));

		areaMensagens = new JTextArea();
		areaMensagens.setFont(new Font("Monospaced", Font.PLAIN, 12));
		areaMensagens.setEditable(false);
		JScrollPane scrollMensagens = new JScrollPane(
				areaMensagens,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
				);
		scrollMensagens.setBorder(BorderFactory.createTitledBorder(" Mensagens do Compilador "));

		JSplitPane splitCentro = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollEditor, scrollMensagens);
		splitCentro.setDividerLocation(500); 
		splitCentro.setContinuousLayout(true);
		
		getContentPane().add(splitCentro, BorderLayout.CENTER);
		
		JPanel barraStatus = new JPanel(new BorderLayout());
		barraStatus.setPreferredSize(new Dimension(1500, 25));
		barraStatus.setBorder(BorderFactory.createEtchedBorder());
		barraStatus.setBackground(new Color(245, 245, 245));

		lblStatusInfo = new JLabel("  Status: Pronto para compilar.");
		lblStatusInfo.setFont(new Font("SansSerif", Font.PLAIN, 11));
		barraStatus.add(lblStatusInfo, BorderLayout.WEST);

		getContentPane().add(barraStatus, BorderLayout.SOUTH);
		
		//AÇÕES DOS BOTÕES
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorCodigo.setText("");
				areaMensagens.setText("");
				lblStatusInfo.setText("Status: ");
			}
		});
		KeyStroke keyNew = KeyStroke.getKeyStroke("control N");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyNew, "acaoNovo");
		contentPane.getActionMap().put("acaoNovo", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNovo.doClick(); 
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
			}
		});
	}
	

}
