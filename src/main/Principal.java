package main;

import controller.ClienteDao;
import controller.ColaboradorDao;
import controller.InsumoDao;
import controller.ProcedimentoDao;
import entidade.Cliente;
import entidade.Colaborador;
import entidade.Insumo;
import entidade.Procedimento;
import java.util.ArrayList;
import view.CadCliente;

public class Principal {
        
    public static Cliente cliente = new Cliente();
    public static ClienteDao clienteDao = new ClienteDao();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public static Insumo insumo = new Insumo();
    public static InsumoDao insumoDao = new InsumoDao();
    public static ArrayList<Insumo> insumos = new ArrayList<Insumo>();
    
    public static Procedimento procedimento = new Procedimento();
    public static ProcedimentoDao procedimentoDao = new ProcedimentoDao();
    public static ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();
    
    public static Colaborador colaborador = new Colaborador();
    public static ColaboradorDao colaboradorDao = new ColaboradorDao();
    public static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    
    public static void main(String[] args) {
        //CadCliente objviewcadcliente = new CadCliente();
        //objviewcadcliente.setVisible(true);
        
    }
}
