/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.*;
import model.*;

/**
 *
 * @author HANIZAR
 */
public class Controller1 extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private Gerbong og;

    private PanelContainer view;

    private String currentView;
    private JPanel mainPanel;

    private mainMenu m;
    private FGerbong g;
    private FKereta k;
    private FRute r;
    private FStasiun s;
    private FTiket t;

    public Controller1(Aplikasi model) {
        this.model = model;
        this.view = new PanelContainer();

        m = new mainMenu();
        g = new FGerbong();
        k = new FKereta();
        r = new FRute();
        s = new FStasiun();
        t = new FTiket();

        m.addListener(this);
        g.addListener(this);
        k.addListener(this);
        r.addListener(this);
        s.addListener(this);
        t.addListener(this);

        mainPanel = view.getMainPanel();
        mainPanel.add(m, "0");
        mainPanel.add(g, "1");
        mainPanel.add(k, "2");
        mainPanel.add(s, "3");
        mainPanel.add(r, "4");
        mainPanel.add(t, "5");
        currentView = "0";

        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
        view.addListener(this);
    }

    /*
        if(source.equals(view.getBtnExit())) {
            view.dispose();
            g.setVisible(true);
        }
        
        if(source.equals(g.getBtnSearch())) {
            String txt = g.getTxtKodeSrc();            
            g.getTaGerbongSrc().setText(currentView);
        }
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnExit())) {
            try {
                model.saveGerbong();
                model.saveKereta();
                model.saveRute();
                model.saveStasiun();
                model.saveTiket();
            } catch (IOException ex) {
                view.viewErrorMessage(ex.getMessage());
            }
            System.exit(0);
        } //current view = Main
        else if (currentView.equals("0")) {
            if (source.equals(m.getBtnGerbong())) {
                //menampilkan gerbong
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
                g.setKodeGerbong("");
                g.setDetailGerbong("");
            } else if (source.equals(m.getBtnKereta())) {
                //menampilkan kereta
                currentView = "2";
                view.getCardLayout().show(mainPanel, currentView);
                k.setDetailKereta("");
            } else if (source.equals(m.getBtnStasiun())) {
                //menampilkan stasiun
                currentView = "3";
                view.getCardLayout().show(mainPanel, currentView);
                s.setTANamaStasiun("");
                s.setTAStasiun("");
            } else if (source.equals(m.getBtnRute())) {
                //menampilkan rute
                currentView = "4";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(m.getBtnTiket())) {
                //menampilkan tiket
                currentView = "5";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("1")) {
            if (source.equals(g.getBtnBack())) {
                currentView = "0";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(g.getBtnSave())) {
                String kode = g.getKodeGerbongIn();
                String jenis = g.getJenisGerbong();
                String jumlah = g.getJumlahGerbong();
                model.addGerbong(kode, jenis, jumlah);
                try {
                    model.saveGerbong();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                g.reset();
            } else if (source.equals(g.getBtnTampil())) {
                String kode = g.getTxtKode().getText();
                try {
                    model.loadGerbong();
                    g.resetData();
                    for (int i = 0; i < model.getDataGerbong().size(); i++) {
                        if (kode.equals(model.getDataGerbong().get(i).getKode())) {
                            g.getTaGerbong().append(model.getDataGerbong().get(i).toString());
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(g.getBtnDelete())) {
                String kode = g.getTxtKode().getText();
                try {
                    for (int i = 0; i < model.getDataGerbong().size(); i++) {
                        if (kode.equals(model.getDataGerbong().get(i).getKode())) {
                            model.deleteGerbong(kode);
                            model.saveGerbong();
                            g.resetData();
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(g.getBtnRefresh())) {
                try {
                    model.loadGerbong();
                    g.getTaKodeGerbong().setText("");
                    for (int i = 0; i < model.getDataGerbong().size(); i++) {
                        g.getTaKodeGerbong().append(model.getDataGerbong().get(i).tampilKode());
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                g.setDetailGerbong("");
            }
        } else if (currentView.equals("2")) {
            if (source.equals(k.getBtnBack())) {
                currentView = "0";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(k.getBtnSave())) {
                String nama = k.getTxtNama();
                String jurusan = k.getTxtJurusan();
                String jenis = k.getCmbJenis();
                model.addKereta(nama, jurusan, jenis);
                try {
                    model.saveKereta();
                    k.reset();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(k.getBtnRefresh())) {
                try {
                    model.loadKereta();
                    k.getTaNamaKereta().setText("");
                    for (int i = 0; i < model.getDataKereta().size(); i++) {
                        k.getTaNamaKereta().append(model.getDataKereta().get(i).tampilNama());
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                k.setDetailKereta("");
            } else if (source.equals(k.getBtnDelete())) {
                String nama = k.getTxtDataNama();
                try {
                    for (int i = 0; i < model.getDataKereta().size(); i++) {
                        if (nama.equals(model.getDataKereta().get(i).getNama())) {
                            model.deleteKereta(nama);
                            model.saveKereta();
                            k.resetData();
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(k.getBtnTampil())) {
                String nama = k.getTxtDataNama();
                try {
                    model.loadKereta();
                    k.resetData();
                    for (int i = 0; i < model.getDataKereta().size(); i++) {
                        if (nama.equals(model.getDataKereta().get(i).getNama())) {
                            k.getTaKereta().append(model.getDataKereta().get(i).toString());
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(k.getBtnAddGerbong())) {
                String kode = k.getTxtKodeGerbong();
                String nama = k.getTxtNamaKereta();
                boolean x = false, y = false;
                int tampungA = 0, tampungB = 0;
                for (int i = 0; i < model.getDataKereta().size(); i++) {
                    if (nama.equals(model.getDataKereta().get(i).getNama())) {
                        x = true;
                        tampungA = i;
                    }
                }
                for (int j = 0; j < model.getDataGerbong().size(); j++) {
                    if (kode.equals(model.getDataGerbong().get(j).getKode())) {
                        y = true;
                        tampungB = j;
                    }
                }
                if ((x == true) && (y == true)) {
                    try {
                        model.setGerbong(tampungA, tampungB);
                        model.saveKereta();
                    } catch (IOException ex) {
                        Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else if (source.equals(k.getBtnRefreshAll())) {
                try {
                    model.loadKereta();
                    model.loadGerbong();
                    k.resetAll();
                    for (int i = 0; i < model.getDataKereta().size(); i++) {
                        k.getTaInfoKereta().append(model.getDataKereta().get(i).toString());
                    }
                    for (int i = 0; i < model.getDataGerbong().size(); i++) {
                        k.getTaInfoGerbong().append(model.getDataGerbong().get(i).show());
                    }
                    for (int i = 0; i < model.getDataKereta().size(); i++) {
                        k.getTaGerbongToKereta().append(model.getDataKereta().get(i).show());
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                k.setDetailKereta("");
            }
        } else if (currentView.equals("3")) {
            if (source.equals(s.getBtnBack())) {
                currentView = "0";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(s.getBtnSave())) {
                String nama = s.getTxtNama();
                String alamat = s.getTxtAlamat();
                String daop = s.getTxtDaop();
                model.addStasiun(nama, alamat, daop);
                try {
                    model.saveStasiun();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                s.reset();
            } else if (source.equals(s.getBtnTampil())) {
                String nama = s.getTxtNama();
                try {
                    model.loadStasiun();
                    for (int i = 0; i < model.getDataStasiun().size(); i++) {
                        if (nama.equals(model.getDataStasiun().get(i).getNama())) {
                            s.getTAStasiun().append(model.getDataStasiun().get(i).toString());
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(s.getBtnDelete())) {
                String nama = s.getTxtNama();
                try {
                    for (int i = 0; i < model.getDataStasiun().size(); i++) {
                        if (nama.equals(model.getDataStasiun().get(i).getNama())) {
                            model.deleteStasiun(nama);
                            model.saveStasiun();
                            g.resetData();
                        }
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(s.getBtnRefresh())) {
                try {
                    model.loadStasiun();
                    for (int i = 0; i < model.getDataStasiun().size(); i++) {
                        s.getTANamaStasiun().append(model.getDataStasiun().get(i).tampilNama());
                    }
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            }
        }
        else if (currentView.equals("4")) {
            if (source.equals(s.getBtnBack())) {
                currentView = "0";                
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(r.getBtnSave())) {
                String kereta = r.getTxtKereta();
                String awal = r.getTxtStasiunAwal();
                String akhir = r.getTxtStasiunAwal();
                int hasil=0;
                boolean x=false;
                for(int i=0; i<model.getDataRute().size(); i++) {
                    if(model.getDataKereta().get(i).getNama().equals(kereta)) {
                        x=true;
                        hasil=i;
                    }
                }
                if (x==true) {
                    try {
                        model.getDataRute()
                        model.saveRute();
                    } catch (IOException ex) {
                        Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int i=0; i<model.getDataRute().size(); i++) {
                    if(model.getDataStasiun().get(i).getNama().equals(awal)) {
                        x=true;
                    }
                }
                try {
                    model.saveStasiun();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(s.getBtnSearchDel())) {
                String nama = s.getTxtNama();
                model.getStasiun(nama);
                try {
                    model.saveStasiun();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(s.getBtnDelete())) {
                String nama = s.getTxtNamaDel();
                model.deleteStasiun(nama);
                try {
                    model.saveStasiun();
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            } else if (source.equals(s.getBtnRefreshDel())) {
                try {
                    model.loadStasiun();
                    s.setIsNamaStasiun(model.getListStasiun());
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
                s.setDetailStasiunDel("");
            } else if (source.equals(s.getBtnRefresh())) {
                try {
                    model.loadStasiun();
                    s.setIsNamaStasiun(model.getListStasiun());
                } catch (IOException ex) {
                    view.viewErrorMessage(ex.getMessage());
                }
            }
        }
    }
}
