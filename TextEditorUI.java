import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TextEditorUI extends JFrame {
    private JTextPane textPane;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> fontSizeComboBox;
    private JToggleButton boldButton;
    private JToggleButton italicButton;
    private JToggleButton uppercaseButton;
    private JToggleButton strikethroughButton;
    private JToggleButton leftAlignButton;
    private JToggleButton rightAlignButton;
    private JToggleButton centerAlignButton;
    private JToggleButton justifyButton;
    private JPanel sketchPad; // Declare sketchPad here

    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUppercase = false;
    private boolean isStrikethrough = false;

    public TextEditorUI() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // File menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Review menu
        JMenu reviewMenu = new JMenu("Review");
        menuBar.add(reviewMenu);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Create menu items for the File menu
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");

        // Add menu items to the File menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);

        // Add menu items to the Review menu
        JMenuItem languageMenuItem = new JMenuItem("Language");
        JMenuItem translateMenuItem = new JMenuItem("Translate");

        // Add menu to the Review menu
        reviewMenu.add(languageMenuItem);
        reviewMenu.add(translateMenuItem);

       
       //Add menu items to edit
       JMenuItem penMenuItem = new JMenuItem("Pen");
       JMenuItem eraserMenuItem = new JMenuItem("Eraser");
       
        //Add menu items to the Edit
        editMenu.add(penMenuItem);
        editMenu.add(eraserMenuItem);

        // Add menu items to help menu
        JMenuItem callsupportMenuItem = new JMenuItem("Call support");

        // Add menu to the help menu
        helpMenu.add(callsupportMenuItem);

        // Create a text pane
        textPane = new JTextPane();
        textPane.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textPane);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create a toolbar for font and alignment options
        JToolBar toolbar = new JToolBar();
        toolbar.add(new JLabel("Font: "));
        fontComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fontSizeComboBox = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36});

        // Create buttons for text formatting
         JButton findButton = new JButton("Find");
        JButton replaceButton = new JButton("Replace");
        boldButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\Downloads\\icons8-bold-30.png", 15, 15)));
        italicButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\Downloads\\icons8-italic-30.png", 15, 15)));
        uppercaseButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\Downloads\\icons8-uppercase-50.png", 15, 15)));
        strikethroughButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\Downloads\\icons8-strike-through-24.png", 15, 15)));

        // Create alignment buttons
        leftAlignButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\OneDrive\\Desktop\\left.jpg", 15, 15)));
        rightAlignButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\OneDrive\\Desktop\\right.jpg", 15, 15)));
        centerAlignButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\OneDrive\\Desktop\\centre.jpg", 15, 15)));
        justifyButton = new JToggleButton(new ImageIcon(getResizedImage("C:\\Users\\diyad\\OneDrive\\Desktop\\justify.jpg", 15, 15)));

       

        // Add action listeners to font and font size dropdowns
        fontComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFont();
            }
        });

        fontSizeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFont();
            }
        });

        // Add action listeners to formatting buttons
        boldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isBold = !isBold;
                toggleBold();
            }
        });

        italicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isItalic = !isItalic;
                toggleItalic();
            }
        });

        uppercaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isUppercase = !isUppercase;
                toggleUppercase();
            }
        });

        strikethroughButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isStrikethrough = !isStrikethrough;
                toggleStrikethrough();
            }
        });

        // Add action listeners to alignment buttons
        leftAlignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAlignment(StyleConstants.ALIGN_LEFT);
            }
        });

        rightAlignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAlignment(StyleConstants.ALIGN_RIGHT);
            }
        });

        centerAlignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAlignment(StyleConstants.ALIGN_CENTER);
            }
        });

        justifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAlignment(StyleConstants.ALIGN_JUSTIFIED);
            }
        });

        // Add components to the toolbar
        toolbar.add(fontComboBox);
        toolbar.add(new JLabel("Size: "));
        toolbar.add(fontSizeComboBox);
        toolbar.add(boldButton);
        toolbar.add(italicButton);
        toolbar.add(uppercaseButton);
        toolbar.add(strikethroughButton);
        toolbar.add(leftAlignButton);
        toolbar.add(rightAlignButton);
        toolbar.add(centerAlignButton);
        toolbar.add(justifyButton);
        toolbar.add(findButton);
        toolbar.add(replaceButton);

getContentPane().add(toolbar, BorderLayout.NORTH);

        // Create the Sketch Pad panel
        sketchPad = new JPanel();
        sketchPad.setBackground(Color.GRAY);
        sketchPad.setPreferredSize(new Dimension(400, getHeight()));

        // Add the Sketch Pad heading
        JLabel sketchPadHeading = new JLabel("Sketch Pad");
        sketchPadHeading.setPreferredSize(new Dimension(400,50));
        sketchPadHeading.setHorizontalAlignment(JLabel.CENTER);

        // Create buttons for drawing options
        JButton rectangleButton = new JButton("Rectangle");
        JButton circleButton = new JButton("Circle");
        JButton lineButton = new JButton("Line");
        JButton triangleButton = new JButton("Triangle");
        JButton parallelogramButton = new JButton("Parallelogram");
        JButton clearButton = new JButton("Clear");

        // Disable the focus border for sketchpad buttons
        rectangleButton.setFocusPainted(false);
        circleButton.setFocusPainted(false);
        lineButton.setFocusPainted(false);
        triangleButton.setFocusPainted(false);
        parallelogramButton.setFocusPainted(false);
        clearButton.setFocusPainted(false);

        // Add components to the Sketch Pad panel
        sketchPad.add(sketchPadHeading);
        sketchPad.add(rectangleButton);
        sketchPad.add(circleButton);
        sketchPad.add(lineButton);
        sketchPad.add(triangleButton);
        sketchPad.add(parallelogramButton);
        sketchPad.add(clearButton);

        // Add the Sketch Pad to the main content pane
        getContentPane().add(sketchPad, BorderLayout.EAST);
    }

    private void setAlignment(int alignment) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributes, alignment);
        doc.setParagraphAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd(), attributes, false);
    }

    private void toggleBold() {
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setBold(attributes, isBold);
        textPane.setCharacterAttributes(attributes, false);
    }

    private void toggleItalic() {
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setItalic(attributes, isItalic);
        textPane.setCharacterAttributes(attributes, false);
    }

    private void toggleUppercase() {
        String text = textPane.getText();
        if (isUppercase) {
            textPane.setText(text.toUpperCase());
        } else {
            textPane.setText(text.toLowerCase());
        }
    }

    private void toggleStrikethrough() {
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setStrikeThrough(attributes, isStrikethrough);
        textPane.setCharacterAttributes(attributes, false);
    }

    // Update the font of the selected text
    private void updateFont() {
        String selectedFont = fontComboBox.getSelectedItem().toString();
        int selectedSize = (int) fontSizeComboBox.getSelectedItem();
        int style = Font.PLAIN;

        if (isBold) {
            style |= Font.BOLD;
        }

        if (isItalic) {
            style |= Font.ITALIC;
        }

        Font newFont = new Font(selectedFont, style, selectedSize);
        textPane.setFont(newFont);
    }
      private Image getResizedImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return resizedImage;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextEditorUI editor = new TextEditorUI();
                editor.setVisible(true);
            }
        });
    }
}