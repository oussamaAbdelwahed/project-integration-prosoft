package android.dsi32.org.proosoft_project.commons;

import android.content.Context;
import android.dsi32.org.proosoft_project.R;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientRpcUtilities  {

    private static Context context;

    public ClientRpcUtilities(Context context) {
        this.context = context;
    }

    public static XmlRpcClient getConfiguredClient(String endpoint) {
        XmlRpcClient xmlRpcClient = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setEnabledForExtensions(true);
        try {
            config.setServerURL(new URL(context.getString(R.string.odoo_server_url)+endpoint));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        xmlRpcClient.setConfig(config);
        return  xmlRpcClient;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ClientRpcUtilities.context = context;
    }
}
