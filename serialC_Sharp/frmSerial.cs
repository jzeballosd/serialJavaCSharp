using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO.Ports;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace serialC_Sharp
{
    public partial class frmSerial : Form
    {
        public frmSerial()
        {
            InitializeComponent();
            Control.CheckForIllegalCrossThreadCalls = false;
        }

        private void puertosDisponibles()
        {
            foreach (string puertoDis in System.IO.Ports.SerialPort.GetPortNames())
            {
                cboListaPuertos.Items.Add(puertoDis);
            }
        }

        private void frmSerial_Load(object sender, EventArgs e)
        {
            puertosDisponibles();
        }

        private void cboListaPuertos_SelectedIndexChanged(object sender, EventArgs e)
        {
            String puerto = cboListaPuertos.Text;
            puertoSerial.PortName = puerto;
            try
            {
                lblEstado.Text = "Estado: Esperando conectar con el puerto : " + puerto;
                puertoSerial.Open();
                lblEstado.Text = "Estado: Conexion exitosa en el puerto : " + puerto;
            }
            catch (Exception ex)
            {
                lblEstado.Text = "Estado: Error en la conexion con el puerto : " + puerto;
            }
        }

        private void puertoSerial_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            string datos = puertoSerial.ReadExisting();
            //MessageBox.Show(datos, "");
            txtResDat.Text = datos;
        }

        private void btnEnviar_Click(object sender, EventArgs e)
        {
            try
            {
                puertoSerial.Write(txtSenData.Text.Trim());
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al enviar datos !!!", "Error");
            }
        }
    }
}
