/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices.crud;

import com.dao.DAOServices;
import com.dao.QueryParameter;
import com.logger.L;
import dataservices.map.*;
import dataservices.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class dbServicesCrud {

    public final static L log = new L(dbServicesCrud.class);

    public static Usuario findUserLogin(String Usuario, String Password, Integer flag) {
        Usuario loginUser = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter joinfuncionario = new QueryParameter(QueryParameter.$TYPE_JOIN);
            joinfuncionario.setJoinAlias("funcionarios");
            joinfuncionario.setJoinOrderNumber(1);
            joinfuncionario.setColumnName("funcionarios");

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName("usuNombre");
            query_1.setWhereClause("=");
            query_1.setValue(Usuario);

            QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_2.setColumnName("usuClaveSecreta");
            query_2.setWhereClause("=");
            query_2.setValue(Password);

            QueryParameter query_3 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_3.setColumnName("usuFlag");
            query_3.setWhereClause("=");
            query_3.setValue(flag);

            List parameList = new ArrayList();
            parameList.add(joinfuncionario);
            parameList.add(query_1);
            parameList.add(query_2);
            parameList.add(query_3);

            List<Usuario> listUserLogin = ds.customQuery(parameList, Usuario.class);

            if (!listUserLogin.isEmpty()) {
                loginUser = listUserLogin.get(0);
                Funcionarios rolFuncionario = null;

                QueryParameter joinrol = new QueryParameter(QueryParameter.$TYPE_JOIN);
                joinrol.setJoinAlias("rol");
                joinrol.setJoinOrderNumber(1);
                joinrol.setColumnName("rol");

                QueryParameter query_r1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
                query_r1.setColumnName("idFun");
                query_r1.setWhereClause("=");
                query_r1.setValue(loginUser.getFuncionarios().getIdFun());

                List parameList_r = new ArrayList();
                parameList_r.add(joinrol);
                parameList_r.add(query_r1);

                List<Funcionarios> listFuncionarios = ds.customQuery(parameList_r, Funcionarios.class);

                if (!listFuncionarios.isEmpty()) {
                    rolFuncionario = listFuncionarios.get(0);
                    loginUser.setFuncionarios(rolFuncionario);
                }
            }
        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return loginUser;
    }

    public static ArrayList<Provincia> getListProvincias() {
        ArrayList<Provincia> mProvincias = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());
            List parameList = new ArrayList();
            List<Provincia> listProvincias = ds.customQuery(parameList, Provincia.class);
            if (!listProvincias.isEmpty()) {
                mProvincias = (ArrayList<Provincia>) listProvincias;
            }
        } catch (Exception ex) {
            log.level.info("getListProvincias : " + ex.getMessage());
        }

        return mProvincias;
    }

    public static ArrayList<Canton> getListCantones(String provNombre) {
        ArrayList<Canton> mCantons = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName("provNombre");
            query_1.setWhereClause("=");
            query_1.setValue(provNombre);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Provincia> selectProvincia = ds.customQuery(parameList, Provincia.class);

            if (!selectProvincia.isEmpty()) {

                QueryParameter query_c1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
                query_c1.setColumnName("idProvincia");
                query_c1.setWhereClause("=");
                query_c1.setValue(selectProvincia.get(0).getIdProvincia());

                List parameList_c = new ArrayList();
                parameList_c.add(query_c1);

                List<Canton> listCantons = ds.customQuery(parameList_c, Canton.class);

                if (!listCantons.isEmpty()) {
                    mCantons = (ArrayList<Canton>) listCantons;
                }

            }
        } catch (Exception ex) {
            log.level.info("getListCantons : " + ex.getMessage());
        }

        return mCantons;
    }

    public static ArrayList<Parroquia> getListParroquias(String canNombre) {
        ArrayList<Parroquia> mParroquias = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_c1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_c1.setColumnName("canNombre");
            query_c1.setWhereClause("=");
            query_c1.setValue(canNombre);

            List parameList_c = new ArrayList();
            parameList_c.add(query_c1);

            List<Canton> selectCanton = ds.customQuery(parameList_c, Canton.class);

            if (!selectCanton.isEmpty()) {

                QueryParameter query_p1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
                query_p1.setColumnName("idCanton");
                query_p1.setWhereClause("=");
                query_p1.setValue(selectCanton.get(0).getIdCanton());

                List parameList_p = new ArrayList();
                parameList_p.add(query_c1);

                List<Parroquia> listParroquia = ds.customQuery(parameList_c, Parroquia.class);

                if (!listParroquia.isEmpty()) {
                    mParroquias = (ArrayList<Parroquia>) listParroquia;
                }

            }

        } catch (Exception ex) {
            log.level.info("getListParroquias : " + ex.getMessage());
        }

        return mParroquias;
    }

    public static Boolean insertCliente(Cliente cliente) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (cliente != null) {
            ds.save(cliente);
            exito = true;
        }
        return exito;
    }

    public static Cliente findClientes(String ColumnName, String Value) {
        Cliente findmCliente = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Cliente> listClients = ds.customQuery(parameList, Cliente.class);

            if (!listClients.isEmpty()) {
                findmCliente = listClients.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmCliente;
    }

    public static Producto findProductos(String ColumnName, String Value) {
        Producto findmProducto = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Producto> listProductos = ds.customQuery(parameList, Producto.class);

            if (!listProductos.isEmpty()) {
                findmProducto = listProductos.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmProducto;
    }

    public static Producto findProductos(String ColumnName, Integer Value) {
        Producto findmProducto = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Producto> listProductos = ds.customQuery(parameList, Producto.class);

            if (!listProductos.isEmpty()) {
                findmProducto = listProductos.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmProducto;
    }

    public static Integer nextNumProductos() {
        Integer numProductos = 0;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            List parameList = new ArrayList();

            List<Producto> listProductos = ds.customQuery(parameList, Producto.class);

            numProductos = listProductos.size() + 1;
            numProductos = numProductos + 10000;

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName("proNumSis");
            query_1.setWhereClause("=");
            query_1.setValue(numProductos);

            List parameListm = new ArrayList();
            parameListm.add(query_1);

            List<Producto> mProductos = ds.customQuery(parameListm, Producto.class);
            Boolean aumentar = mProductos.isEmpty();
            while (!aumentar) {
                numProductos = numProductos + 1;
                QueryParameter query_1m = new QueryParameter(QueryParameter.$TYPE_WHERE);
                query_1m.setColumnName("proNumSis");
                query_1m.setWhereClause("=");
                query_1m.setValue(numProductos);

                List parameList1m = new ArrayList();
                parameList1m.add(query_1m);
                List<Producto> m1Productos = ds.customQuery(parameList1m, Producto.class);

                aumentar = m1Productos.isEmpty();

            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return numProductos;
    }

    public static Boolean insertProducto(Producto producto) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (producto != null) {
            ds.save(producto);
            exito = true;
        }
        return exito;
    }

    public static ArrayList<Marca> getListMarcas() {
        ArrayList<Marca> mMarcas = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());
            List parameList = new ArrayList();
            List<Marca> listMarcas = ds.customQuery(parameList, Marca.class);
            if (!listMarcas.isEmpty()) {
                mMarcas = (ArrayList<Marca>) listMarcas;
            }
        } catch (Exception ex) {
            log.level.info("getListMarcas : " + ex.getMessage());
        }

        return mMarcas;
    }

    public static ArrayList<Pro> getListProNombres() {
        ArrayList<Pro> mProNombres = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());
            List parameList = new ArrayList();
            List<Pro> listProNombres = ds.customQuery(parameList, Pro.class);
            if (!listProNombres.isEmpty()) {
                mProNombres = (ArrayList<Pro>) listProNombres;
            }
        } catch (Exception ex) {
            log.level.info("getListProNombres : " + ex.getMessage());
        }

        return mProNombres;
    }

    public static Boolean insertGarantia(Garantia garantia) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (garantia != null) {
            ds.save(garantia);
            exito = true;
        }
        return exito;
    }

    public static ArrayList<Almacen> getListAlmacenes() {
        ArrayList<Almacen> mAlmacenes = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());
            List parameList = new ArrayList();
            List<Almacen> listAlmacenes = ds.customQuery(parameList, Almacen.class);
            if (!listAlmacenes.isEmpty()) {
                mAlmacenes = (ArrayList<Almacen>) listAlmacenes;
            }
        } catch (Exception ex) {
            log.level.info("getListAlmacene : " + ex.getMessage());
        }

        return mAlmacenes;
    }

    public static Integer nextNumOrdenes() {
        Integer numOrdenes = 0;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            List parameList = new ArrayList();

            List<Orden> listOrdenes = ds.customQuery(parameList, Orden.class);

            numOrdenes = listOrdenes.size() + 1;
            numOrdenes = numOrdenes + 10000;

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName("ordNumSis");
            query_1.setWhereClause("=");
            query_1.setValue(numOrdenes);

            List parameListm = new ArrayList();
            parameListm.add(query_1);

            List<Orden> mOrdenes = ds.customQuery(parameListm, Orden.class);
            Boolean aumentar = mOrdenes.isEmpty();

            while (!aumentar) {
                numOrdenes = numOrdenes + 1;
                QueryParameter query_1m = new QueryParameter(QueryParameter.$TYPE_WHERE);
                query_1m.setColumnName("ordNumSis");
                query_1m.setWhereClause("=");
                query_1m.setValue(numOrdenes);

                List parameListm1 = new ArrayList();
                parameListm1.add(query_1m);

                List<Orden> m1Ordenes = ds.customQuery(parameListm1, Orden.class);

                aumentar = m1Ordenes.isEmpty();
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return numOrdenes;
    }

    public static Orden findOrden(String ColumnName, Integer Value) {
        Orden findmOrden = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Orden> listOrdenes = ds.customQuery(parameList, Orden.class);

            if (!listOrdenes.isEmpty()) {
                findmOrden = listOrdenes.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmOrden;
    }

    public static Boolean insertOrden(Orden orden) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (orden != null) {
            ds.save(orden);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertRegistro(Registro registro) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (registro != null) {
            ds.save(registro);
            exito = true;
        }
        return exito;
    }

    public static Orden findOrden(String ColumnName, String Value) {
        Orden findmOrden = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);

            List<Orden> listClients = ds.customQuery(parameList, Orden.class);

            if (!listClients.isEmpty()) {
                findmOrden = listClients.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmOrden;
    }

    public static ArrayList<Orden> findOrdens(String ColumnName, String Value, String JoinAlias) {
        ArrayList<Orden> findmOrden = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter join = new QueryParameter(QueryParameter.$TYPE_JOIN);
            join.setJoinAlias(JoinAlias);
            join.setJoinOrderNumber(1);
            join.setColumnName(JoinAlias);

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(query_1);
            parameList.add(join);

            List<Orden> listClients = ds.customQuery(parameList, Orden.class);

            if (!listClients.isEmpty()) {
                findmOrden = (ArrayList<Orden>) listClients;
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmOrden;
    }

    public static ArrayList<Orden> findOrdens(String ColumnName, Integer Value, String JoinAlias) {
        ArrayList<Orden> findmOrden = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter join = new QueryParameter(QueryParameter.$TYPE_JOIN);
            join.setJoinAlias(JoinAlias);
            join.setJoinOrderNumber(1);
            join.setColumnName(JoinAlias);

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(join);
            parameList.add(query_1);

            List<Orden> listClients = ds.customQuery(parameList, Orden.class);

            if (!listClients.isEmpty()) {
                findmOrden = (ArrayList<Orden>) listClients;
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmOrden;
    }

    public static ArrayList<Estado> getListEstados() {
        ArrayList<Estado> mEstados = null;

        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());
            List parameList = new ArrayList();
            List<Estado> listEstados = ds.customQuery(parameList, Estado.class);
            if (!listEstados.isEmpty()) {
                mEstados = (ArrayList<Estado>) listEstados;
            }
        } catch (Exception ex) {
            log.level.info("getListEstados : " + ex.getMessage());
        }

        return mEstados;
    }

    public static Boolean updateCliente(Cliente cliente) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (cliente != null) {
            ds.update(cliente);
            exito = true;
        }
        return exito;
    }

    public static Boolean updateProducto(Producto producto) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (producto != null) {
            ds.update(producto);
            exito = true;
        }
        return exito;
    }

    public static ArrayList<Producto> findProductos(String ColumnName, Integer Value, String JoinAlias) {
        ArrayList<Producto> findmProducto = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter join = new QueryParameter(QueryParameter.$TYPE_JOIN);
            join.setJoinAlias(JoinAlias);
            join.setJoinOrderNumber(1);
            join.setColumnName(JoinAlias);

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName);
            query_1.setWhereClause("=");
            query_1.setValue(Value);

            List parameList = new ArrayList();
            parameList.add(join);
            parameList.add(query_1);

            List<Producto> listProductos = ds.customQuery(parameList, Producto.class);

            if (!listProductos.isEmpty()) {
                findmProducto = (ArrayList<Producto>) listProductos;
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmProducto;
    }

    public static Garantia findGarantias(String ColumnName1, Integer Value1, String ColumnName2, Integer Value2) {
        Garantia findmGarantia = null;
        try {
            DAOServices ds = new DAOServices(dbServicesHibernateUtil.
                    getSessionFactory().getCurrentSession());

            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName(ColumnName1);
            query_1.setWhereClause("=");
            query_1.setValue(Value1);

            QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_2.setColumnName(ColumnName2);
            query_2.setWhereClause("=");
            query_2.setValue(Value2);

            List parameList = new ArrayList();
            parameList.add(query_1);
            parameList.add(query_2);

            List<Garantia> listGarantias = ds.customQuery(parameList, Garantia.class);

            if (!listGarantias.isEmpty()) {
                findmGarantia = listGarantias.get(0);
            }

        } catch (Exception ex) {
            log.level.info("findUserLogin : " + ex.getMessage());
        }

        return findmGarantia;
    }

}
