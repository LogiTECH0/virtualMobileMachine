package virtualMobileMachine;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Phone extends Frame {
	int number = 0;
    private TextField timeTextField;
    private TextField passwordTextField;
    private TextField newTimeTextField;
    private StringBuilder passwordBuilder = new StringBuilder();
    private final int PASSWORD = 180711;
    int RAND;
	int randCount;
	int backg = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Phone unlockScreen = new Phone("Mobile");
                unlockScreen.setVisible(true);
            }
        });
    }

    public Phone(String title) {
        super(title);
        setSize(312, 675);
        setLayout(new BorderLayout());

        Panel centerPanel = new Panel(new BorderLayout());
        passwordTextField = new TextField(10);
        passwordTextField.setEditable(false);
        centerPanel.add(passwordTextField, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new GridLayout(4, 3));

        for (int i = 1; i <= 9; i++) {
            Button button = new Button(Integer.toString(i));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    passwordBuilder.append(button.getLabel());
                    passwordTextField.setText(passwordBuilder.toString());
                }
            });
            buttonPanel.add(button);
        }

        Button zeroButton = new Button("0");
        zeroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordBuilder.append(zeroButton.getLabel());
                passwordTextField.setText(passwordBuilder.toString());
            }
        });
        buttonPanel.add(zeroButton);

        Button clearButton = new Button("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordBuilder.setLength(0);
                passwordTextField.setText("");
            }
        });
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        passwordTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String password = passwordTextField.getText();
                if (password.equals(Integer.toString(PASSWORD))) {
                    openNewWindow();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void openNewWindow() {
        Frame newFrame = new Frame("Mobile Phone");
        newFrame.setSize(312, 675);
        newFrame.setLayout(new BorderLayout());
        newFrame.setResizable(false);
        newFrame.setBackground(new Color(197,150,228));
        
        Panel topPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        newTimeTextField = new TextField(10);
        newTimeTextField.setEditable(false);
        TextField version = new TextField("Teacup 1");
        version.setBackground(new Color(240,227,249));
        newTimeTextField.setBackground(new Color(240,227,249));
        version.setEditable(false);
        
        updateTime(newTimeTextField);
        topPanel.add(newTimeTextField);
        topPanel.add(version);
        
        newFrame.add(topPanel, BorderLayout.NORTH);
        
        Panel centerPanel = new Panel(new BorderLayout());
        newFrame.add(centerPanel, BorderLayout.CENTER);
        
        Panel newButtonPanel = new Panel(new GridLayout(9, 4));
        
        Button calls = new Button("Дзвінки");
        Button calculator = new Button("Калькулятор");
        Button random = new Button("Гра");
        Button telegram = new Button("Телеграм");
        Button tasks = new Button("Задачі");
        Button money = new Button("Конвертер валют");
        TextField reklama = new TextField("Мій особистий тг канал - https://t.me/ukrainian_dev");
        
        reklama.setBackground(new Color(0,205,255));
        calls.setBackground(new Color(80,255,115));
        calculator.setBackground(new Color(3,188,255));
        random.setBackground(new Color(255,169,253));
        telegram.setBackground(new Color(0,205,253));
        tasks.setBackground(new Color(188,255,0));
        
        newButtonPanel.add(reklama);
        newButtonPanel.add(calls);
        newButtonPanel.add(calculator);
        newButtonPanel.add(random);
        newButtonPanel.add(telegram);
        newButtonPanel.add(tasks);
        
        reklama.setEditable(false);
        
        calls.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCalls();
                newFrame.setVisible(false);
            }
        });
        calculator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCalculator();
                newFrame.setVisible(false);
            }
        });
        random.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openRandomizer();
                newFrame.setVisible(false);
            }
        });
        telegram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTelegram();
                newFrame.setVisible(false);
            }
        });
        tasks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTasks();
                newFrame.setVisible(false);
            }
        });
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateTime(newTimeTextField);
            }
        }, 0, 1000);
           
        centerPanel.add(newButtonPanel, BorderLayout.SOUTH);
        
        newFrame.setVisible(true);
    }

    private void updateTime(TextField textField) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String currentTime = formatter.format(date);
        textField.setText(currentTime);
    }
    private void openCalculator() {
    	Frame calculator = new Frame("Calculator");
    	calculator.setLayout(new BorderLayout());
    	calculator.setSize(450, 375);
    	calculator.setResizable(false);
    	calculator.setBackground(new Color(0,230,255));

    	Panel p = new Panel();
		calculator.add(p,BorderLayout.CENTER);
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button mode = new Button("MODE");
		Button act = new Button("ACTION");
		Button c = new Button("C");
		Button zero = new Button("0");
		Button zero2 = new Button("0");
		Button one2 = new Button("1");
		Button two2 = new Button("2");
		Button three2 = new Button("3");
		Button four2 = new Button("4");
		Button five2 = new Button("5");
		Button six2 = new Button("6");
		Button seven2 = new Button("7");
		Button eight2 = new Button("8");
		Button nine2 = new Button("9");
		Button home = new Button("HOME");
		TextField text = new TextField("");
		TextField text2 = new TextField("");
		TextField result = new TextField("");
		TextField sign = new TextField("+");
		text.setEditable(false);
		sign.setEditable(false);
		text2.setEditable(false);
		result.setEditable(false);
		text.setPreferredSize(new Dimension(175,50));
		sign.setPreferredSize(new Dimension(50,50));
		text2.setPreferredSize(new Dimension(175,50));
		result.setPreferredSize(new Dimension(225,50));
		home.setPreferredSize(new Dimension(375,50));
		one.setPreferredSize(new Dimension(50, 50));
		one2.setPreferredSize(new Dimension(50, 50));
		two.setPreferredSize(new Dimension(50, 50));
		two2.setPreferredSize(new Dimension(50, 50));
		three.setPreferredSize(new Dimension(50, 50));
		three2.setPreferredSize(new Dimension(50, 50));
		four.setPreferredSize(new Dimension(50, 50));
		four2.setPreferredSize(new Dimension(50, 50));
		five.setPreferredSize(new Dimension(50, 50));
		five2.setPreferredSize(new Dimension(50, 50));
		six.setPreferredSize(new Dimension(50, 50));
		six2.setPreferredSize(new Dimension(50, 50));
		seven.setPreferredSize(new Dimension(50, 50));
		seven2.setPreferredSize(new Dimension(50, 50));
		eight.setPreferredSize(new Dimension(50, 50));
		eight2.setPreferredSize(new Dimension(50, 50));
		nine.setPreferredSize(new Dimension(50, 50));
		nine2.setPreferredSize(new Dimension(50, 50));
		c.setPreferredSize(new Dimension(50, 50));
		zero.setPreferredSize(new Dimension(75, 50));
		mode.setPreferredSize(new Dimension(50, 50));
		act.setPreferredSize(new Dimension(50, 50));
		zero2.setPreferredSize(new Dimension(75, 50));
		one.setBackground(new Color(0,196,255));
		one2.setBackground(new Color(0,196,255));
		two.setBackground(new Color(0,196,255));
		two2.setBackground(new Color(0,196,255));
		three.setBackground(new Color(0,196,255));
		three2.setBackground(new Color(0,196,255));
		four.setBackground(new Color(0,196,255));
		four2.setBackground(new Color(0,196,255));
		five.setBackground(new Color(0,196,255));
		five2.setBackground(new Color(0,196,255));
		six.setBackground(new Color(0,196,255));
		six2.setBackground(new Color(0,196,255));
		seven.setBackground(new Color(0,196,255));
		seven2.setBackground(new Color(0,196,255));
		eight.setBackground(new Color(0,196,255));
		eight2.setBackground(new Color(0,196,255));
		nine.setBackground(new Color(0,196,255));
		nine2.setBackground(new Color(0,196,255));
		c.setBackground(new Color(255,0,0));
		zero.setBackground(new Color(0,196,255));
		mode.setBackground(new Color(0,196,255));
		act.setBackground(new Color(0,196,255));
		zero2.setBackground(new Color(0,196,255));
		p.add(text);
		p.add(sign);
		p.add(text2);
		p.add(one);
		p.add(two);
		p.add(three);
		p.add(mode);
		p.add(one2);
		p.add(two2);
		p.add(three2);
		p.add(four);
		p.add(five);
		p.add(six);
		p.add(act);
		p.add(four2);
		p.add(five2);
		p.add(six2);
		p.add(seven);
		p.add(eight);
		p.add(nine);
		p.add(c);
		p.add(seven2);
		p.add(eight2);
		p.add(nine2);
		p.add(zero);
		p.add(result);
		p.add(zero2);
		p.add(home);
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 1;
				text.setText(text.getText() + number);
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 2;
				text.setText(text.getText() + number);
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 3;
				text.setText(text.getText() + number);
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 4;
				text.setText(text.getText() + number);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 5;
				text.setText(text.getText() + number);
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 6;
				text.setText(text.getText() + number);
			}
		});
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 7;
				text.setText(text.getText() + number);
			}
		});
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 8;
				text.setText(text.getText() + number);
			}
		});
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 9;
				text.setText(text.getText() + number);
			}
		});
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 0;
				text.setText(text.getText() + number);
			}
		});
		one2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 1;
				text2.setText(text2.getText() + number);
			}
		});
		two2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 2;
				text2.setText(text2.getText() + number);
			}
		});
		three2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 3;
				text2.setText(text2.getText() + number);
			}
		});
		four2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 4;
				text2.setText(text2.getText() + number);
			}
		});
		five2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 5;
				text2.setText(text2.getText() + number);
			}
		});
		six2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 6;
				text2.setText(text2.getText() + number);
			}
		});
		seven2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 7;
				text2.setText(text2.getText() + number);
			}
		});
		eight2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 8;
				text2.setText(text2.getText() + number);
			}
		});
		nine2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 9;
				text2.setText(text2.getText() + number);
			}
		});
		zero2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 0;
				text2.setText(text2.getText() + number);
			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				text.setText("");
				text2.setText("");
				result.setText("");
			}
		});
		mode.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        String sig = sign.getText();
		        if (sig.equals("+")) {
		            sig = "-";
		            sign.setText(sig);
		        } else if (sig.equals("-")) {
		            sig = "*";
		            sign.setText(sig);
		        } else if (sig.equals("*")) {
		            sig = "/";
		            sign.setText(sig);
		        } else if (sig.equals("/")) {
		            sig = "+";
		            sign.setText(sig);
		        }
		    }
		});
		act.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String sig = sign.getText();
				if(sig.equals("+")) {
					int first = Integer.parseInt(text.getText());
					int second = Integer.parseInt(text2.getText());
					int third = first + second;
					String finish = String.valueOf(third);
					result.setText(finish);
				}
				else if(sig.equals("-")) {
					int first = Integer.parseInt(text.getText());
					int second = Integer.parseInt(text2.getText());
					int third = first - second;
					String finish = String.valueOf(third);
					result.setText(finish);
				}
				else if(sig.equals("*")) {
					int first = Integer.parseInt(text.getText());
					int second = Integer.parseInt(text2.getText());
					int third = first * second;
					String finish = String.valueOf(third);
					result.setText(finish);
				}
				else if(sig.equals("/")) {
					double first = Double.parseDouble(text.getText());
					double second = Double.parseDouble(text2.getText());
					double third = first / second;
					String finish = String.valueOf(third);
					result.setText(finish);
				}
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openNewWindow();
				calculator.setVisible(false);
			}
		});
    	calculator.setVisible(true);
    }
    private void openRandomizer() {
    	Frame randomizer = new Frame("Randomizer");
    	
    	randomizer.setLayout(new BorderLayout());
    	randomizer.setSize(200, 600);
    	randomizer.setResizable(false);
    	randomizer.setBackground(Color.CYAN);
    	
    	Panel calc = new Panel();
		randomizer.add(calc, BorderLayout.CENTER);
		
		Button enter = new Button("Enter");
		TextField text = new TextField("");
		Button ten = new Button("Від 0 до 10");
		Button twfive = new Button("Від 0 до 25");
		Button fifty = new Button("Від 0 до 50");
		Button hund = new Button("Від 0 до 100");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		Button home = new Button("HOME");
		
		text.setEditable(false);
		
		ten.setBackground(new Color(0, 255, 0));
		twfive.setBackground(new Color(255, 255, 0));
		fifty.setBackground(new Color(255, 0, 0));
		hund.setBackground(new Color(0,0,0));
		hund.setForeground(new Color(255, 255, 255));
		one.setBackground(new Color(0, 196, 255));
		two.setBackground(new Color(0, 196, 255));
		three.setBackground(new Color(0, 196, 255));
		four.setBackground(new Color(0, 196, 255));
		five.setBackground(new Color(0, 196, 255));
		six.setBackground(new Color(0, 196, 255));
		seven.setBackground(new Color(0, 196, 255));
		eight.setBackground(new Color(0, 196, 255));
		nine.setBackground(new Color(0, 196, 255));
		zero.setBackground(new Color(0, 196, 255));
		enter.setBackground(new Color(0, 196, 255));
		ten.setPreferredSize(new Dimension(150, 50));
		twfive.setPreferredSize(new Dimension(150, 50));
		fifty.setPreferredSize(new Dimension(150, 50));
		hund.setPreferredSize(new Dimension(150, 50));
		home.setPreferredSize(new Dimension(150, 50));
		enter.setPreferredSize(new Dimension(100, 50));
		text.setPreferredSize(new Dimension(50, 50));
		one.setPreferredSize(new Dimension(50, 50));
		two.setPreferredSize(new Dimension(50, 50));
		three.setPreferredSize(new Dimension(50, 50));
		four.setPreferredSize(new Dimension(50, 50));
		five.setPreferredSize(new Dimension(50, 50));
		six.setPreferredSize(new Dimension(50, 50));
		seven.setPreferredSize(new Dimension(50, 50));
		eight.setPreferredSize(new Dimension(50, 50));
		nine.setPreferredSize(new Dimension(50, 50));
		zero.setPreferredSize(new Dimension(150, 50));
		
		calc.add(enter);
		calc.add(text);
		calc.add(one);
		calc.add(two);
		calc.add(three);
		calc.add(four);
		calc.add(five);
		calc.add(six);
		calc.add(seven);
		calc.add(eight);
		calc.add(nine);
		calc.add(zero);
		calc.add(ten);
		calc.add(twfive);
		calc.add(fifty);
		calc.add(hund);
		calc.add(home);
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 1;
				text.setText(text.getText() + number);
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 2;
				text.setText(text.getText() + number);
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 3;
				text.setText(text.getText() + number);
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 4;
				text.setText(text.getText() + number);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 5;
				text.setText(text.getText() + number);
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 6;
				text.setText(text.getText() + number);
			}
		});
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 7;
				text.setText(text.getText() + number);
			}
		});
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 8;
				text.setText(text.getText() + number);
			}
		});
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 9;
				text.setText(text.getText() + number);
			}
		});
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 0;
				text.setText(text.getText() + number);
			}
		});
		ten.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        randCount = 10;
		        RAND = new Random().nextInt(randCount) + 1; 
		    }
		});
		twfive.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        randCount = 25;
		        RAND = new Random().nextInt(randCount) + 1; 
		    }
		});
		fifty.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        randCount = 50;
		        RAND = new Random().nextInt(randCount) + 1; 
		    }
		});
		hund.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        randCount = 100;
		        RAND = new Random().nextInt(randCount) + 1; 
		    }
		});
		enter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        int inter = Integer.parseInt(text.getText());
		        if (inter < RAND) {
		        	text.setText("Треба");
		            try {
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		            text.setText("Більше");
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		            text.setText("");
		        }
		        if (inter > RAND) {
		        	text.setText("Треба");
		            try {
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		            text.setText("Менше");
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		            text.setText("");
		        }
		        if(inter == RAND) {
		            text.setText("Вірно!");
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		            text.setText("");
		        }
		    }
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openNewWindow();
				randomizer.setVisible(false);
			}
		});
		
		randomizer.setVisible(true);
    }
    private void openCalls() {
    	Frame calls = new Frame("Calls");
    	calls.setSize(312,525);
    	calls.setResizable(false);
    	calls.setLayout(new BorderLayout());
    	
    	Panel p = new Panel();
		calls.add(p,BorderLayout.CENTER);
		TextField text = new TextField("");
		Button c = new Button("C");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button sharp = new Button("#");
		Button zero = new Button("0");
		Button star = new Button("*");
		Button home = new Button("HOME");
		Button enter = new Button("ENTER");
		
		text.setEditable(false);
		one.setPreferredSize(new Dimension(75,75));
		two.setPreferredSize(new Dimension(75,75));
		three.setPreferredSize(new Dimension(75,75));
		four.setPreferredSize(new Dimension(75,75));
		five.setPreferredSize(new Dimension(75,75));
		six.setPreferredSize(new Dimension(75,75));
		seven.setPreferredSize(new Dimension(75,75));
		eight.setPreferredSize(new Dimension(75,75));
		nine.setPreferredSize(new Dimension(75,75));
		zero.setPreferredSize(new Dimension(75,75));
		sharp.setPreferredSize(new Dimension(75,75));
		star.setPreferredSize(new Dimension(75,75));
		home.setPreferredSize(new Dimension(100, 50));
		enter.setPreferredSize(new Dimension(100, 50));
		c.setPreferredSize(new Dimension(75,75));
		text.setPreferredSize(new Dimension(150,75));
		
		p.add(text);
		p.add(c);
		p.add(one);
		p.add(two);
		p.add(three);
		p.add(four);
		p.add(five);
		p.add(six);
		p.add(seven);
		p.add(eight);
		p.add(nine);
		p.add(star);
		p.add(zero);
		p.add(sharp);
		p.add(home);
		p.add(enter);
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 1;
				text.setText(text.getText() + number);
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 2;
				text.setText(text.getText() + number);
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 3;
				text.setText(text.getText() + number);
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 4;
				text.setText(text.getText() + number);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 5;
				text.setText(text.getText() + number);
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 6;
				text.setText(text.getText() + number);
			}
		});
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 7;
				text.setText(text.getText() + number);
			}
		});
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 8;
				text.setText(text.getText() + number);
			}
		});
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 9;
				text.setText(text.getText() + number);
			}
		});
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				number = 0;
				text.setText(text.getText() + number);
			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				text.setText("");
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openNewWindow();
				calls.setVisible(false);
			}
		});
		enter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        String num = text.getText();
		        if (num.equals("0981318404")) {
		            try {
		                File audioFile = new File("msg6024038031-14984.wav");
		                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
		                Clip clip = AudioSystem.getClip();
		                clip.open(audioIn);
		                clip.start();
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		                e.printStackTrace();
		            }
		        }
		        if (num.equals("123456789")) {
		            try {
		                File audioFile = new File("derzhavnij_gimn_ukrani_-_shche_ne_vmerla_ukrana__z3 (mp3cut.net).wav");
		                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
		                Clip clip = AudioSystem.getClip();
		                clip.open(audioIn);
		                clip.start();
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		                e.printStackTrace();
		            }
		        }
		        if (num.equals("0967563205")) {
		            try {
		                File audioFile = new File("msg2056664254-14927.wav");
		                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
		                Clip clip = AudioSystem.getClip();
		                clip.open(audioIn);
		                clip.start();
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		                e.printStackTrace();
		            }
		        }
		        if (num.equals("0971675715")) {
		            try {
		                File audioFile = new File("msg5271592819-15072.wav");
		                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
		                Clip clip = AudioSystem.getClip();
		                clip.open(audioIn);
		                clip.start();
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		});
		
    	calls.setVisible(true);
    }
    private void openTelegram() {
    	Frame telegram = new Frame("Calculator");
    	telegram.setLayout(new BorderLayout());
    	telegram.setSize(312, 675);
    	telegram.setResizable(false);
    	
    	Panel p = new Panel();
		telegram.add(p,BorderLayout.CENTER);
		Button chat = new Button("Winter with Java 2.0 (6+7 клас)");
		Button home = new Button("HOME");
		Button channelUK = new Button("Український розробник");
		Button channelIZ = new Button("Izrel Teams");
		
		home.setPreferredSize(new Dimension(225,75));
		chat.setPreferredSize(new Dimension(225,75));
		channelUK.setPreferredSize(new Dimension(225,75));
		channelIZ.setPreferredSize(new Dimension(225,75));
		
		p.add(chat);
		p.add(channelUK);
		p.add(channelIZ);
		p.add(home);
		
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openWinterJava();
				telegram.setVisible(false);
			}
		});
		channelUK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openWinterJava();
				telegram.setVisible(false);
			}
		});
		channelIZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openWinterJava();
				telegram.setVisible(false);
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openNewWindow();
				telegram.setVisible(false);
			}
		});
    	
    	telegram.setVisible(true);
    }
    private void openWinterJava() {
        Frame winter = new Frame("Chat");
        winter.setLayout(new BorderLayout());
        winter.setSize(312, 675);
        winter.setResizable(false);
        
        Panel p = new Panel();
        winter.add(p, BorderLayout.CENTER);
        Button home = new Button("HOME");
        Button send = new Button("»»");
        TextField message = new TextField("");
        
        send.setPreferredSize(new Dimension(50, 50));
        home.setPreferredSize(new Dimension(50, 50));
        message.setPreferredSize(new Dimension(125, 50));
        
        p.add(message);
        p.add(send);
        p.add(home);
        
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String textToSend = message.getText();
                message.setText("");
                TextArea textSent = new TextArea(textToSend);
                textSent.setEditable(false);
                textSent.setPreferredSize(new Dimension(225, 50));
                p.add(textSent);
                p.revalidate();
                p.repaint();
            }
        });
        home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTelegram();
				winter.setVisible(false);
			}
		});
        
        winter.setVisible(true);
    }
    private void openTasks() {
    	Frame tasks = new Frame("Tasks");
    	tasks.setLayout(new BorderLayout());
    	tasks.setSize(312, 450);
    	tasks.setResizable(false);
    	
    	Panel p = new Panel();
        tasks.add(p, BorderLayout.CENTER);
        Button home = new Button("HOME");
        Button one = new Button("1. (7+9)²");
        Button two = new Button("2. 9²+14²");
        Button three = new Button("3. 56% від 83");
        Button four = new Button("4. 2x+4=3x−1");
        Button five = new Button("5. 4х+5х-10=15-7");
        Button next = new Button("NEXT PAGE");
        
        home.setPreferredSize(new Dimension(250, 50));
        one.setPreferredSize(new Dimension(250, 50));
        two.setPreferredSize(new Dimension(250, 50));
        three.setPreferredSize(new Dimension(250, 50));
        four.setPreferredSize(new Dimension(250, 50));
        five.setPreferredSize(new Dimension(250, 50));
        next.setPreferredSize(new Dimension(250, 50));
        
        p.add(one);
        p.add(two);
        p.add(three);
        p.add(four);
        p.add(five);
        p.add(next);
        p.add(home);
        
        home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openNewWindow();
				tasks.setVisible(false);
			}
		});
        one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openOne();
				tasks.setVisible(false);
			}
		});
        two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTwo();
				tasks.setVisible(false);
			}
		});
        three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openThree();
				tasks.setVisible(false);
			}
		});
        four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openFour();
				tasks.setVisible(false);
			}
		});
    	tasks.setVisible(true);
    }
    private void openOne() {
    	Frame one = new Frame("1.");
    	one.setLayout(new BorderLayout());
    	one.setSize(275, 215);
    	one.setResizable(false);
    	
    	Panel p = new Panel();
    	one.add(p, BorderLayout.CENTER);
    	TextField answer = new TextField("");
    	TextField task = new TextField("Розв'язати приклад (7+9)²");
    	Button enter = new Button("»»");
    	Button home = new Button("BACK");
    	
    	task.setEditable(false);
    	
    	answer.setPreferredSize(new Dimension(200,25));
    	home.setPreferredSize(new Dimension(200, 50));
    	
    	p.add(task);
    	p.add(answer);
    	p.add(enter);
    	p.add(home);
    	
    	enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String str = answer.getText();
				int answerInt = Integer.parseInt(str);
				if(answerInt == 256)
				{
					answer.setText("ПРАВИЛЬНО");
				}
				else
				{
					answer.setText("НЕПРАВИЛЬНО");
				}
			}
		});
    	home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTasks();
				one.setVisible(false);
			}
		});
    	
    	one.setVisible(true);
    }
    private void openTwo() {
    	Frame two = new Frame("2.");
    	two.setLayout(new BorderLayout());
    	two.setSize(275, 215);
    	two.setResizable(false);
    	
    	Panel p = new Panel();
    	two.add(p, BorderLayout.CENTER);
    	TextField answer = new TextField("");
    	TextField task = new TextField("Розв'язати приклад 9²+14²");
    	Button enter = new Button("»»");
    	Button home = new Button("BACK");
    	
    	task.setEditable(false);
    	
    	answer.setPreferredSize(new Dimension(200,25));
    	home.setPreferredSize(new Dimension(200, 50));
    	
    	p.add(task);
    	p.add(answer);
    	p.add(enter);
    	p.add(home);
    	
    	enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String str = answer.getText();
				int answerInt = Integer.parseInt(str);
				if(answerInt == 277)
				{
					answer.setText("ПРАВИЛЬНО");
				}
				else
				{
					answer.setText("НЕПРАВИЛЬНО");
				}
			}
		});
    	home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTasks();
				two.setVisible(false);
			}
		});
    	
    	two.setVisible(true);
    }
    private void openThree() {
    	Frame three = new Frame("3.");
    	three.setLayout(new BorderLayout());
    	three.setSize(275, 215);
    	three.setResizable(false);
    	
    	Panel p = new Panel();
    	three.add(p, BorderLayout.CENTER);
    	TextField answer = new TextField("");
    	TextField task = new TextField("Знайти 56% від 83");
    	Button enter = new Button("»»");
    	Button home = new Button("BACK");
    	
    	task.setEditable(false);
    	
    	answer.setPreferredSize(new Dimension(200,25));
    	home.setPreferredSize(new Dimension(200, 50));
    	
    	p.add(task);
    	p.add(answer);
    	p.add(enter);
    	p.add(home);
    	
    	enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String str = answer.getText();
				double answerInt = Double.parseDouble(str);
				if(answerInt == 46.48)
				{
					answer.setText("ПРАВИЛЬНО");
				}
				else
				{
					answer.setText("НЕПРАВИЛЬНО");
				}
			}
		});
    	home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTasks();
				three.setVisible(false);
			}
		});
    	
    	three.setVisible(true);
    }
    private void openFour() {
    	Frame three = new Frame("4.");
    	three.setLayout(new BorderLayout());
    	three.setSize(275, 215);
    	three.setResizable(false);
    	
    	Panel p = new Panel();
    	three.add(p, BorderLayout.CENTER);
    	TextField answer = new TextField("");
    	TextField task = new TextField("4. Розв'яжіть рівняння 2x+4=3x−1");
    	Button enter = new Button("»»");
    	Button home = new Button("BACK");
    	
    	task.setEditable(false);
    	
    	answer.setPreferredSize(new Dimension(200,25));
    	home.setPreferredSize(new Dimension(200, 50));
    	
    	p.add(task);
    	p.add(answer);
    	p.add(enter);
    	p.add(home);
    	
    	enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String str = answer.getText();
				double answerInt = Double.parseDouble(str);
				if(answerInt == 5)
				{
					answer.setText("ПРАВИЛЬНО");
				}
				else
				{
					answer.setText("НЕПРАВИЛЬНО");
				}
			}
		});
    	home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTasks();
				three.setVisible(false);
			}
		});
    	
    	three.setVisible(true);
    }
    private void openFive() {
    	Frame three = new Frame("5.");
    	three.setLayout(new BorderLayout());
    	three.setSize(275, 215);
    	three.setResizable(false);
    	
    	Panel p = new Panel();
    	three.add(p, BorderLayout.CENTER);
    	TextField answer = new TextField("");
    	TextField task = new TextField("5. Розв'яжіть рівняння 4х+5х-10=15-7");
    	Button enter = new Button("»»");
    	Button home = new Button("BACK");
    	
    	task.setEditable(false);
    	
    	answer.setPreferredSize(new Dimension(200,25));
    	home.setPreferredSize(new Dimension(200, 50));
    	
    	p.add(task);
    	p.add(answer);
    	p.add(enter);
    	p.add(home);
    	
    	enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String str = answer.getText();
				double answerInt = Double.parseDouble(str);
				if(answerInt == 2)
				{
					answer.setText("ПРАВИЛЬНО");
				}
				else
				{
					answer.setText("НЕПРАВИЛЬНО");
				}
			}
		});
    	home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openTasks();
				three.setVisible(false);
			}
		});
    	
    	three.setVisible(true);
    }
}