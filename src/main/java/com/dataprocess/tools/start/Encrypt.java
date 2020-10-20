package com.dataprocess.tools.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <pre>
 *  file:main.java.com.sibu.dataprocess.start.Encrypt
 *  Copyright (c) 2020, wljs.com All Rights Reserved.
 *
 *  Description:
 *  {TODO}
 *
 *  Revision History
 *  Date,                    Who,                       What;
 *  2020/5/31 20:09          @author yangtaiwei         Initial.
 *
 * </pre>
 */
public class Encrypt
{
    public static void main(final String[] args) {
        //awt是单线程模式的，所有awt的组件只能在推荐方式的事件处理线程中访问，从而保证组件状态的正确性
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                //声明JFrame
                final JFrame frame = new JFrame("Encrypt加密");
                //文本框
                final JTextArea textarea = new JTextArea(20, 70);
                textarea.setLineWrap(true);//设置为自动换行
                textarea.setWrapStyleWord(true);//超长行在边距处自动换行
                final JScrollPane scroller = new JScrollPane(textarea);//滚动条效果

                final JTextField pwd = new JTextField("", 5);
                final JTextField salt = new JTextField("", 5);

                final JPanel pwdPanel = new JPanel();
                pwdPanel.setLayout(new BorderLayout());
                final JLabel pwdLabel = new JLabel("pwd  ");
                pwdPanel.add(pwdLabel,BorderLayout.WEST);
                pwdPanel.add(pwd,BorderLayout.CENTER);

                final JPanel saltPanel = new JPanel();
                saltPanel.setLayout(new BorderLayout());
                final JLabel saltLabel = new JLabel("salt   ");
                saltPanel.add(saltLabel,BorderLayout.WEST);
                saltPanel.add(salt,BorderLayout.CENTER);

                //显示加密后内容的textarea
                final JTextArea textarea2 = new JTextArea(20, 70);
                textarea2.setLineWrap(true);
                textarea2.setWrapStyleWord(true);
                final JScrollPane scroller2 = new JScrollPane(textarea2);

                //加密，退出按钮
                final JButton start = new JButton("开始加密");
                //开始计算相似度事件
                start.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tempStrA = textarea.getText();
                        String pwdStr = pwd.getText();
                        String saltStr = salt.getText();
                        if(pwdStr.length() == 0){
                            JOptionPane.showMessageDialog(null, "     您好，请输需要加密PWD！ ", "提    示", JOptionPane.ERROR_MESSAGE);
                        }
                        if(saltStr.length() == 0){
                            JOptionPane.showMessageDialog(null, "     您好，请输需要加密SALT！ ", "提    示", JOptionPane.ERROR_MESSAGE);
                        }
                        //如果textarea都不为空，则进行加密。
                        if(tempStrA.length() != 0){
                            //显示相似内容于textarea_res
                            textarea2.setText(CipherUtil.pbeEncrypt(tempStrA, pwdStr, saltStr));
                        }else{
                            JOptionPane.showMessageDialog(null, "     您好，请输需要加密的内容！ ", "提    示", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                final JButton cancel = new JButton("退        出");
                //退出事件
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();//释放窗体所占资源
                        System.exit(0);//退出程序
                    }
                });

                //文件一north
                final Box north = Box.createVerticalBox();//竖排列
                north.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));//边距
                north.add(pwdPanel);
                north.add(saltPanel);
                north.add(Box.createVerticalStrut(10));
                north.add(Box.createVerticalStrut(5));
                north.add(scroller);
                frame.add(north, BorderLayout.NORTH);
                //文件二center
                final Box center = Box.createVerticalBox();
                center.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                center.add(Box.createVerticalStrut(5));
                center.add(scroller2);
                frame.add(center,BorderLayout.CENTER);
                //south
                final Box south = Box.createHorizontalBox();
                south.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                south.add(Box.createHorizontalGlue());//按钮居中显示
                south.add(start);
                south.add(Box.createHorizontalStrut(20));//水平间距
                south.add(cancel);
                south.add(Box.createVerticalStrut(5));
                frame.add(south,BorderLayout.SOUTH);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体默认退出形式
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}
