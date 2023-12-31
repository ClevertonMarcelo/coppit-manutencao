/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

// TODO: Auto-generated Javadoc
/**
 * The Class NewGameDialog.
 */
public class NewGameDialog extends JFrame implements ActionListener,
		InputMethodListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2880824120804425314L;

	/** The click new game_. */
	private JButton clickNewGame_;

	/** The clicked new game listener_. */
	private ActionListener clickedNewGameListener_;

	/** The listr of player names_. */
	private ArrayList<JTextField> listrOfPlayerNames_ = new ArrayList<JTextField>();

	/** The computer player check box_. */
	private ArrayList<JCheckBox> computerPlayerCheckBox_ = new ArrayList<JCheckBox>();

	/** The plyer color list_. */
	private ArrayList<ColorpickDialog> plyerColorList_ = new ArrayList<ColorpickDialog>();

	/** The list of player element names_. */
	private ArrayList<JLabel> listOfPlayerElementNames_ = new ArrayList<JLabel>();

	/** The list of players_. */
	private JList<String> listOfPlayers_;

	/** The list model. */
	private DefaultListModel<String> listModel;

	/** The start game. */
	private JButton startGame;

	/** The menu game. */
	private JButton menuGame;

	/** The Start new game action_. */
	private ActionListener StartNewGameAction_;

	/** The mouse listener_. */
	private MouseListener mouseListener_;

	/** The analyse game button_. */
	private JButton analyseGameButton_;

	/** The clicked analyse_. */
	private ActionListener clickedAnalyse_;

	/** The counting_. */
	private int counting_;

	/** The choose replay game_. */
	private JFileChooser chooseReplayGame_;

	/** The directory_. */
	private Object directory_;

	/** The reset game_. */
	private JButton resetGame_;

	/** The reset game act_. */
	private ActionListener resetGameAct_;
	
	private Image image;
	
	private boolean firstScreen = true;

	private String computer = "BOT PLAYER";

	public static void main(String ...args) throws IOException {
		 new NewGameDialog();
	}
	
	/**
	 * Instantiates a new new game dialog.
	 * @throws IOException 
	 */
	public NewGameDialog() throws IOException {
		super();
		this.setSize(1000, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.BLACK);
		this.setEnabled(true);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.white);
		this.setLocationByPlatform(true);
		this.setTitle("COPPIT GAME");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/de/uni_mannheim/swt/pm_7/fdh/gui/coppitIcon.png"));	
        this.loadImage();

		JFrame frame = new JFrame();
		// Obter o dispositivo gráfico padrão
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		// Verificar se o dispositivo suporta o modo de tela cheia
		if (device.isFullScreenSupported()) {
			// Definir o estado da janela como maximizado
			this.setExtendedState(frame.MAXIMIZED_BOTH);

			// Definir o dispositivo gráfico como tela cheia
			device.setFullScreenWindow(frame);
		} else {
			// Se o modo de tela cheia não for suportado, defina a janela com um tamanho fixo
			frame.setSize(800, 600);
			frame.setLocationRelativeTo(null); // Centralizar a janela na tela
		}

		this.initButton();
		this.getContentPane().add(this.clickNewGame_);
		this.setResizable(false);
		// this.setUndecorated(true);
		this.setVisible(true);

		for (int i = 0; i < 4; i++) {
			this.listrOfPlayerNames_.add(new JTextField());
			this.computerPlayerCheckBox_.add(new JCheckBox());
			this.plyerColorList_.add(new ColorpickDialog());
			this.listOfPlayerElementNames_.add(new JLabel());

		}
		this.initList();
		this.getContentPane().add(this.listOfPlayers_);
		this.validate();
		this.repaint();
	}
	
	private void loadImage() {
		try {
			image = ImageIO.read(new File("src/de/uni_mannheim/swt/pm_7/fdh/gui/coppitLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(firstScreen) {
			g.drawImage(image, 370, 80, this);
		}	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.InputMethodListener#caretPositionChanged(java.awt.event
	 * .InputMethodEvent)
	 */
	@Override
	public void caretPositionChanged(InputMethodEvent arg0) {

	}

	/**
	 * Inits the button.
	 */
	private void initButton() {
		int width = 200;
		int height = 100;
		this.clickNewGame_ = new JButton(Messages.getString("NewGameDialog.0")); //$NON-NLS-1$
		this.clickNewGame_.setBounds(this.getWidth() / 2 - width / 2,
				this.getHeight() / 2 - height / 2, width, height);
		this.clickNewGame_.setForeground(Color.WHITE);
		this.clickNewGame_.setBackground(Color.BLACK);
		this.clickNewGame_.setVisible(true);
		 // Cria uma borda simples com cor vermelha
        Border border = BorderFactory.createLineBorder(Color.RED);
		this.clickNewGame_.setBorder(border);
		this.clickedNewGameListener_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstScreen = false;
				NewGameDialog.this.counting_ = NewGameDialog.this.listOfPlayers_
						.getSelectedIndices()[0];
				NewGameDialog.this.openPlayerDialog();

			}

		};
		this.clickNewGame_.addActionListener(this.clickedNewGameListener_);

		this.analyseGameButton_ = new JButton(
				Messages.getString("NewGameDialog.1")); //$NON-NLS-1$
		this.analyseGameButton_.setBounds(this.getWidth() / 4 - width / 2,
				this.getHeight() / 2 - height / 2, width, height);
		this.analyseGameButton_.setForeground(Color.CYAN);
		this.analyseGameButton_.setBackground(Color.BLACK);
		this.analyseGameButton_.setVisible(true);
		this.analyseGameButton_.setBorder(border);
		this.getContentPane().add(this.analyseGameButton_);
		this.clickedAnalyse_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				NewGameDialog.this.openAnalyseDialog();

			}

		};
		this.analyseGameButton_.addActionListener(this.clickedAnalyse_);

		this.resetGame_ = new JButton(Messages.getString("NewGameDialog.10")); //$NON-NLS-1$
		this.resetGame_.setBounds((int) (this.getWidth() / 1.33 - width / 2),
				this.getHeight() / 2 - height / 2, width, height);
		this.resetGame_.setForeground(Color.GREEN);
		this.resetGame_.setBackground(Color.BLACK);
		this.resetGame_.setVisible(true);
		this.resetGame_.setBorder(border);
		this.getContentPane().add(this.resetGame_);
		this.resetGameAct_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				NewGameDialog.this.openLastGame();

			}

		};
		this.resetGame_.addActionListener(this.resetGameAct_);

	}

	/**
	 * Inits the list.
	 */
	private void initList() {
		int width = 200;
		int height = 200;
		this.listModel = new DefaultListModel<String>();
		this.listModel.addElement(Messages.getString("NewGameDialog.2")); //$NON-NLS-1$
		this.listModel.addElement(Messages.getString("NewGameDialog.3")); //$NON-NLS-1$
		this.listModel.addElement(Messages.getString("NewGameDialog.4")); //$NON-NLS-1$
		this.listOfPlayers_ = new JList<String>(this.listModel);
		this.listOfPlayers_.setSelectedIndex(1);
		this.listOfPlayers_.setBounds(this.getWidth() / 2 - width / 2,
				this.getHeight() / 2 - height / 2 + 200, width, height);
		this.listOfPlayers_.setForeground(Color.YELLOW);
		this.listOfPlayers_.setBackground(Color.BLACK);
		this.listOfPlayers_.setVisible(true);
		// Cria uma borda simples com cor vermelha
        Border border = BorderFactory.createLineBorder(Color.RED);
		this.listOfPlayers_.setBorder(border);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.InputMethodListener#inputMethodTextChanged(java.awt.event
	 * .InputMethodEvent)
	 */
	@Override
	public void inputMethodTextChanged(InputMethodEvent arg0) {

	}

	/**
	 * Open analyse dialog.
	 */
	protected void openAnalyseDialog() {
		this.chooseReplayGame_ = new JFileChooser();
		String property = Messages.getString("NewGameDialog.5"); //$NON-NLS-1$
		this.directory_ = System.getProperty(property);
		File file = new File(this.directory_
				+ Messages.getString("NewGameDialog.6")); //$NON-NLS-1$
		file.mkdir();
		this.chooseReplayGame_.setCurrentDirectory(file);
		int state = this.chooseReplayGame_.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			File chosenFile = this.chooseReplayGame_.getSelectedFile();
			System.out.println(chosenFile.getAbsolutePath());
			this.openReplayMode(chosenFile);
		}

		this.chooseReplayGame_.setVisible(true);

	}

	/**
	 * Open last game.
	 */
	protected void openLastGame() {

		String property = Messages.getString("NewGameDialog.5"); //$NON-NLS-1$
		this.directory_ = System.getProperty(property);
		File file = new File(this.directory_
				+ Messages.getString("NewGameDialog.6")); //$NON-NLS-1$
		file.mkdir();
		File tempfile = file.listFiles()[0];
		for (File f : file.listFiles()) {
			if (f.lastModified() > tempfile.lastModified()) {
				tempfile = f;
			}
		}
		this.openResetGame(tempfile);
	}

	/**
	 * Open player dialog.
	 */
	private void openPlayerDialog() {
		// testing
		int num = this.listOfPlayers_.getLeadSelectionIndex() + 2;

		this.mouseListener_ = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (ColorpickDialog c : NewGameDialog.this.plyerColorList_) {

					if (c.getColor().equals(
							((ColorpickDialog) e.getSource()).getColor())) {
						c.setUnselected();
					}
				}

			}
			

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				for (ColorpickDialog c : NewGameDialog.this.plyerColorList_) {
					if (c.getColor().equals(
							((ColorpickDialog) e.getSource()).getColor())) {
						c.setUnselected();
					}
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		this.getContentPane().removeAll();

		for (int i = 0; i < num; i++) {
			this.listOfPlayerElementNames_.get(i).setBounds(50, (80 * i) + 30,
					110, 30);
			this.listOfPlayerElementNames_.get(i).setText(
					Messages.getString("NewGameDialog.7") + (i + 1)); //$NON-NLS-1$
			this.listOfPlayerElementNames_.get(i).setForeground(Color.YELLOW);
			this.listOfPlayerElementNames_.get(i).setBackground(Color.BLACK);
			this.listOfPlayerElementNames_.get(i).setVisible(true);

			this.listrOfPlayerNames_.get(i).setBounds(200, (80 * i) + 30, 100,
					30);
			this.listrOfPlayerNames_.get(i).setVisible(true);
			this.listrOfPlayerNames_.get(i).setForeground(Color.GRAY);
			this.listrOfPlayerNames_.get(i).setBackground(Color.BLACK);
			// änder noch nicht automatisch
			this.listrOfPlayerNames_.get(i).addInputMethodListener(this);
			this.listrOfPlayerNames_.get(i).setText(
					this.listOfPlayerElementNames_.get(i).getText());

			this.computerPlayerCheckBox_.get(i).setBounds(400, (80 * i) + 30,
					100, 30);
			this.computerPlayerCheckBox_.get(i).setText(
					Messages.getString("NewGameDialog.8")); //$NON-NLS-1$
			this.computerPlayerCheckBox_.get(i).setVisible(true);
			this.computerPlayerCheckBox_.get(i).setForeground(Color.CYAN);
			this.computerPlayerCheckBox_.get(i).setBackground(Color.BLACK);

			this.plyerColorList_.get(i).setLocation(600, (80 * i) + 30);
			this.plyerColorList_.get(i).addMouseListener(this.mouseListener_);
			this.plyerColorList_.get(i).setVisible(true);

			Border border = BorderFactory.createLineBorder(Color.BLUE);
			this.listOfPlayerElementNames_.get(i).setBorder(border);

			Border borderdigiBorder = BorderFactory.createEtchedBorder(getBackground(), getForeground());
			this.listrOfPlayerNames_.get(i).setBorder(borderdigiBorder);
		}
		for (JTextField f : this.listrOfPlayerNames_) {
			this.getContentPane().add(f);
		}

		for (JCheckBox f : this.computerPlayerCheckBox_) {
			this.getContentPane().add(f);
		}

		for (JLabel f : this.listOfPlayerElementNames_) {
			this.getContentPane().add(f);
		}

		for (ColorpickDialog f : this.plyerColorList_) {
			this.getContentPane().add(f);
		}

		this.menuGame = new JButton(Messages.getString("FDHBoardView.13"));
		this.menuGame.setBounds(this.getWidth() - 500, this.getHeight() - 90,
		200, 40);
		this.menuGame.setForeground(Color.RED);
		this.menuGame.setBackground(new Color(100, 100, 100, 200));
		this.menuGame.setVisible(true);

		menuGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new NewGameDialog();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		});

		
		this.startGame = new JButton(Messages.getString("NewGameDialog.9")); //$NON-NLS-1$
		this.startGame.setBounds(this.getWidth() - 230, this.getHeight() - 90,
				200, 40);
		this.startGame.setForeground(Color.GREEN);
		this.startGame.setBackground(new Color(100, 100, 100, 200));
		this.startGame.setVisible(true);
		// Cria uma borda simples com cor azul
        Border border = BorderFactory.createLineBorder(Color.BLUE);
		this.startGame.setBorder(border);
		this.menuGame.setBorder(border);
		this.StartNewGameAction_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGameDialog.this.startNewGame();
			}

		};
		this.startGame.addActionListener(this.StartNewGameAction_);
		this.getContentPane().add(this.startGame);

		this.getContentPane().add(this.menuGame);

		this.validate();
		this.repaint();
	}

	/**
	 * Open replay mode.
	 *
	 * @param chosenFile the chosen file
	 */
	private void openReplayMode(File chosenFile) {

		try {
			this.setVisible(false);
			FDHMainView game = new FDHMainView(this);
			game.setEnabled(true);
			game.repaint();
			game.validate();
			game.initReplayMode(chosenFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Open reset game.
	 *
	 * @param tempfile the tempfile
	 */
	private void openResetGame(File tempfile) {
		try {
			this.setVisible(false);
			FDHMainView game = new FDHMainView(this);
			game.setEnabled(true);
			game.repaint();
			game.validate();
			game.initResetMode(tempfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Start new game.
	 */
	protected void startNewGame() {
	    // Check if any player has not selected a color
	    for (int i = 0; i < counting_; i++) {
	        if (plyerColorList_.get(i).getColor() == null) {
	            JOptionPane.showMessageDialog(this, "Por favor, selecione uma cor para cada player!");
	            return; // Stop the method if a player hasn't selected a color
	        }
	    }

	    setVisible(false);
	    FDHMainView game = new FDHMainView(this);
	    game.setEnabled(true);
	    game.repaint();
	    game.validate();

	    counting_ = listOfPlayers_.getAnchorSelectionIndex() + 2;
	    System.out.print(counting_);
	    String[] names = new String[counting_];
	    Color[] color = new Color[counting_];
	    boolean[] computer = new boolean[counting_];

	    try {
	        int i = 0;

	        while (i < counting_) {
	            color[i] = plyerColorList_.get(i).getColor();
	            names[i] = listrOfPlayerNames_.get(i).getText();
	            computer[i] = computerPlayerCheckBox_.get(i).isSelected();
	            i++;
	        }

	        game.initGame(names, color, computer);
	        game.displayPlayers();
	    } catch (Exception e) {
	        e.printStackTrace();
	        e.getMessage();
	    }

	    dispose();
	}


}