/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices.crud;

import com.logger.L;
import dataservices.map.*;
import dataservices.util.*;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class dbServicesMethods {

    private final static L log = new L(dbServicesMethods.class);

    static {
        dbServicesHibernateUtil.init();
    }

    public static Usuario FindUserLogin(String Usuario, String Password, Integer flag) {
        Usuario findfuncionario = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (Usuario != null && Password != null && flag != null) {
                findfuncionario = dbServicesCrud.findUserLogin(Usuario, Password, flag);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findfuncionario;
    }

    public static ArrayList<Provincia> GetListProvincias() {
        ArrayList<Provincia> mProvincias = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mProvincias = dbServicesCrud.getListProvincias();
        } catch (Exception ex) {
            log.level.error("GetListProvincias : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mProvincias;
    }

    public static ArrayList<Canton> GetListCantones(String provNombre) {
        ArrayList<Canton> mCantons = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mCantons = dbServicesCrud.getListCantones(provNombre);
        } catch (Exception ex) {
            log.level.error("GetListCantons : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mCantons;
    }

    public static ArrayList<Parroquia> GetListParroquias(String canNombre) {
        ArrayList<Parroquia> mParroquias = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mParroquias = dbServicesCrud.getListParroquias(canNombre);
        } catch (Exception ex) {
            log.level.error("GetListParroquias : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mParroquias;
    }

    public static Boolean InsertCliente(Cliente cliente) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cliente != null) {
                exito = dbServicesCrud.insertCliente(cliente);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static Cliente FindClientes(String ColumnName, String Value) {
        Cliente findmCliete = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmCliete = dbServicesCrud.findClientes(ColumnName, Value);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmCliete;
    }

    public static Producto FindProductos(String ColumnName, String Value) {
        Producto findmProducto = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmProducto = dbServicesCrud.findProductos(ColumnName, Value);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmProducto;
    }

    public static Producto FindProductos(String ColumnName, Integer Value) {
        Producto findmProducto = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmProducto = dbServicesCrud.findProductos(ColumnName, Value);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmProducto;
    }

    public static Integer NextNumProductos() {
        Integer numProductos = 0;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            numProductos = dbServicesCrud.nextNumProductos();

        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return numProductos;
    }

    public static Boolean InsertProducto(Producto producto) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (producto != null) {
                exito = dbServicesCrud.insertProducto(producto);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static ArrayList<Marca> GetListMarcas() {
        ArrayList<Marca> mMarcas = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mMarcas = dbServicesCrud.getListMarcas();
        } catch (Exception ex) {
            log.level.error("GetListMarcas : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mMarcas;
    }

    public static ArrayList<Pro> GetListProNombres() {
        ArrayList<Pro> mProNombres = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mProNombres = dbServicesCrud.getListProNombres();
        } catch (Exception ex) {
            log.level.error("GetListProNombres : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mProNombres;
    }

    public static Boolean InsertGarantia(Garantia garantia) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (garantia != null) {
                exito = dbServicesCrud.insertGarantia(garantia);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static ArrayList<Almacen> GetListAlmacenes() {
        ArrayList<Almacen> mAlmacenes = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mAlmacenes = dbServicesCrud.getListAlmacenes();
        } catch (Exception ex) {
            log.level.error("GetListAlmacenes : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mAlmacenes;
    }

    public static Integer NextNumOrdenes() {
        Integer numOrdenes = 0;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            numOrdenes = dbServicesCrud.nextNumOrdenes();

        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return numOrdenes;
    }

    public static Orden FindOrden(String ColumnName, Integer Value) {
        Orden findmOrden = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmOrden = dbServicesCrud.findOrden(ColumnName, Value);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmOrden;
    }

    public static Boolean InsertOrden(Orden orden) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (orden != null) {
                exito = dbServicesCrud.insertOrden(orden);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static Boolean InsertRegistro(Registro registro) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (registro != null) {
                exito = dbServicesCrud.insertRegistro(registro);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static Orden FindOrden(String ColumnName, String Value) {
        Orden findmOrden = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmOrden = dbServicesCrud.findOrden(ColumnName, Value);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmOrden;
    }

    public static ArrayList<Orden> FindOrdens(String ColumnName, String Value, String JoinAlias) {
        ArrayList<Orden> findmOrden = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmOrden = dbServicesCrud.findOrdens(ColumnName, Value, JoinAlias);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmOrden;
    }

    public static ArrayList<Orden> FindOrdens(String ColumnName, Integer Value, String JoinAlias) {
        ArrayList<Orden> findmOrden = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmOrden = dbServicesCrud.findOrdens(ColumnName, Value, JoinAlias);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmOrden;
    }

    public static ArrayList<Estado> GetListEstados() {
        ArrayList<Estado> mEstados = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            mEstados = dbServicesCrud.getListEstados();
        } catch (Exception ex) {
            log.level.error("GetListEstados : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return mEstados;
    }

    public static Boolean UpdateCliente(Cliente cliente) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cliente != null) {
                exito = dbServicesCrud.updateCliente(cliente);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static Boolean UpdateProducto(Producto producto) {
        Boolean exito = false;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (producto != null) {
                exito = dbServicesCrud.updateProducto(producto);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }

    public static ArrayList<Producto> FindProductos(String ColumnName, Integer Value, String JoinAlias) {
        ArrayList<Producto> findmProducto = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName != null && Value != null) {
                findmProducto = dbServicesCrud.findProductos(ColumnName, Value, JoinAlias);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmProducto;
    }

    public static Garantia FindGarantias(String ColumnName1, Integer Value1, String ColumnName2, Integer Value2) {
        Garantia findmGarantia = null;
        dbServicesHibernateSessionHandler hss = new dbServicesHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (ColumnName1 != null && Value1 != null
                    && ColumnName2 != null && Value2 != null) {
                findmGarantia = dbServicesCrud.findGarantias(ColumnName1, Value1, ColumnName2, Value2);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmGarantia;
    }

}
