package projeto.compilador.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

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
	private File arquivoAtual = null;

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
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovo.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/new-document.png")));
		JButton btnAbrir = new JButton("Abrir [ctrl-o]");
		barraFerramentas.add(btnAbrir);
		btnAbrir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAbrir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAbrir.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/open-folder.png")));
		JButton btnSalvar = new JButton("Salvar [ctrl-s]");
		barraFerramentas.add(btnSalvar);
		btnSalvar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/save.png")));
		JButton btnCopiar = new JButton("Copiar [ctrl-c]");
		barraFerramentas.add(btnCopiar);
		btnCopiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCopiar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/copy.png")));
		JButton btnColar = new JButton("Colar [ctrl-v]");
		barraFerramentas.add(btnColar);
		btnColar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnColar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnColar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/paste.png")));
		JButton btnRecortar = new JButton("Recortar [ctrl-x]");
		barraFerramentas.add(btnRecortar);
		btnRecortar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRecortar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecortar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/scissor.png")));
		JButton btnCompilar = new JButton("Compilar [F7]");
		barraFerramentas.add(btnCompilar);
		btnCompilar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCompilar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCompilar.setIcon(new ImageIcon(getClass().getResource("/projeto/compilador/images/start.png")));
		JButton btnEquipe = new JButton("Equipe [F1]");
		barraFerramentas.add(btnEquipe);
		btnEquipe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEquipe.setHorizontalTextPosition(SwingConstants.CENTER);
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

		lblStatusInfo = new JLabel("");
		lblStatusInfo.setFont(new Font("SansSerif", Font.PLAIN, 11));
		barraStatus.add(lblStatusInfo, BorderLayout.WEST);

		getContentPane().add(barraStatus, BorderLayout.SOUTH);
		
		//AÇÕES DOS BOTÕES
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorCodigo.setText("");
				areaMensagens.setText("");
				lblStatusInfo.setText("");
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
		
		btnAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				
				fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt"));
				
				int resultado = fileChooser.showOpenDialog(Interface.this);
				
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File arquivoSelecionado = fileChooser.getSelectedFile();
					
					try {
						editorCodigo.read(new java.io.FileReader(arquivoSelecionado), null);
						
						arquivoAtual = arquivoSelecionado;
						
						areaMensagens.setText("");

						lblStatusInfo.setText(  arquivoAtual.getParentFile().getName()  + "/" + arquivoAtual.getName());
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(Interface.this, "Erro ao ler o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		KeyStroke KeyAbrir = KeyStroke.getKeyStroke("control O");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyAbrir, "acaoAbrir");
		contentPane.getActionMap().put("acaoAbrir", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAbrir.doClick(); 
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File arquivoParaSalvar = arquivoAtual;
				
				if (arquivoParaSalvar == null) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt"));
					
					int resultado = fileChooser.showSaveDialog(Interface.this);
					
					if (resultado == JFileChooser.APPROVE_OPTION) {
						arquivoParaSalvar = fileChooser.getSelectedFile();
						
						if (!arquivoParaSalvar.getName().toLowerCase().endsWith(".txt")) {
							arquivoParaSalvar = new File(arquivoParaSalvar.getAbsolutePath() + ".txt");
						}
					} else {
						return;
					}
				}
				try (java.io.FileWriter writer = new java.io.FileWriter(arquivoParaSalvar)) {
					editorCodigo.write(writer);
					arquivoAtual = arquivoParaSalvar;
					
					areaMensagens.setText("");
					
					lblStatusInfo.setText(  arquivoAtual.getParentFile().getName() + "/" + arquivoAtual.getName());
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Interface.this, "Erro ao salvar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		KeyStroke KeySalvar = KeyStroke.getKeyStroke("control S");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeySalvar, "acaoSalvar");
		contentPane.getActionMap().put("acaoSalvar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvar.doClick(); 
			}
		});
		
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorCodigo.copy();
			}
		});
		KeyStroke keyCopiar = KeyStroke.getKeyStroke("control C");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCopiar, "acaoCopiar");
		contentPane.getActionMap().put("acaoCopiar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCopiar.doClick(); 
			}
		});
		
		btnRecortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorCodigo.cut();
			}
		});
		KeyStroke keyRecortar = KeyStroke.getKeyStroke("control X");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyRecortar, "acaoRecortar");
		contentPane.getActionMap().put("acaoRecortar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRecortar.doClick(); 
			}
		});
		
		btnColar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorCodigo.paste();
			}
		});
		KeyStroke keyColar = KeyStroke.getKeyStroke("control V");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyColar, "acaoColar");
		contentPane.getActionMap().put("acaoColar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnColar.doClick(); 
			}
		});
		
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaMensagens.setText("");
				areaMensagens.setText("compilação de programas ainda não foi implementada");
			}
		});
		KeyStroke keyCommpilar = KeyStroke.getKeyStroke("F1");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCommpilar, "acaoCompilar");
		contentPane.getActionMap().put("acaoCompilar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCompilar.doClick(); 
			}
		});
		
		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaMensagens.setText("");
				areaMensagens.setText("Lucas Edson Machado e Pedro Henrique Comandolli");
			}
		});
		KeyStroke keyEquipe = KeyStroke.getKeyStroke("F7");
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEquipe, "acaoEquipe");
		contentPane.getActionMap().put("acaoEquipe", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEquipe.doClick(); 
			}
		});
	}
	
	
}
