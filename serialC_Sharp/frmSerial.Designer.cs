using System.Text;

namespace serialC_Sharp
{
    partial class frmSerial
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();

            ASCIIEncoding asciiEncoding1 = (ASCIIEncoding)new ASCIIEncoding().Clone();
            
            label1 = new Label();
            cboListaPuertos = new ComboBox();
            lblEstado = new Label();
            puertoSerial = new System.IO.Ports.SerialPort(components);
            label3 = new Label();
            btnEnviar = new Button();
            txtResDat = new Label();
            txtSenData = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(36, 48);
            label1.Name = "label1";
            label1.Size = new Size(145, 20);
            label1.TabIndex = 0;
            label1.Text = "Puertos disponibles :";
            // 
            // cboListaPuertos
            // 
            cboListaPuertos.FormattingEnabled = true;
            cboListaPuertos.Location = new Point(214, 45);
            cboListaPuertos.Name = "cboListaPuertos";
            cboListaPuertos.Size = new Size(169, 28);
            cboListaPuertos.TabIndex = 1;
            cboListaPuertos.Text = "Seleccionar puerto";
            cboListaPuertos.SelectedIndexChanged += cboListaPuertos_SelectedIndexChanged;
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(36, 90);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(61, 20);
            lblEstado.TabIndex = 2;
            lblEstado.Text = "Estado :";
            // 
            // puertoSerial
            // 
            puertoSerial.BaudRate = 9600;
            puertoSerial.DataBits = 8;
            puertoSerial.DiscardNull = false;
            puertoSerial.DtrEnable = false;
            asciiEncoding1.DecoderFallback = new DecoderExceptionFallback();
            asciiEncoding1.EncoderFallback = new EncoderExceptionFallback();
            puertoSerial.Encoding = asciiEncoding1;
            puertoSerial.Handshake = System.IO.Ports.Handshake.None;
            puertoSerial.NewLine = "\n";
            puertoSerial.Parity = System.IO.Ports.Parity.None;
            puertoSerial.ParityReplace = 63;
            puertoSerial.PortName = "COM1";
            puertoSerial.ReadBufferSize = 4096;
            puertoSerial.ReadTimeout = -1;
            puertoSerial.ReceivedBytesThreshold = 1;
            puertoSerial.RtsEnable = false;
            puertoSerial.StopBits = System.IO.Ports.StopBits.One;
            puertoSerial.WriteBufferSize = 2048;
            puertoSerial.WriteTimeout = -1;
            puertoSerial.DataReceived += puertoSerial_DataReceived;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(36, 124);
            label3.Name = "label3";
            label3.Size = new Size(120, 20);
            label3.TabIndex = 4;
            label3.Text = "Datos recibidos :";
            // 
            // btnEnviar
            // 
            btnEnviar.Location = new Point(265, 233);
            btnEnviar.Name = "btnEnviar";
            btnEnviar.Size = new Size(118, 29);
            btnEnviar.TabIndex = 7;
            btnEnviar.Text = "Enviar Datos";
            btnEnviar.UseVisualStyleBackColor = true;
            btnEnviar.Click += btnEnviar_Click;
            // 
            // txtResDat
            // 
            txtResDat.BorderStyle = BorderStyle.FixedSingle;
            txtResDat.ForeColor = SystemColors.ControlText;
            txtResDat.Location = new Point(41, 155);
            txtResDat.Name = "txtResDat";
            txtResDat.Size = new Size(342, 49);
            txtResDat.TabIndex = 9;
            // 
            // txtSenData
            // 
            txtSenData.Location = new Point(41, 235);
            txtSenData.Name = "txtSenData";
            txtSenData.Size = new Size(202, 27);
            txtSenData.TabIndex = 10;
            // 
            // frmSerial
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(420, 293);
            Controls.Add(txtSenData);
            Controls.Add(txtResDat);
            Controls.Add(btnEnviar);
            Controls.Add(label3);
            Controls.Add(lblEstado);
            Controls.Add(cboListaPuertos);
            Controls.Add(label1);
            Name = "frmSerial";
            Text = "frmSerial";
            Load += frmSerial_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private ComboBox cboListaPuertos;
        private System.IO.Ports.SerialPort puertoSerial;
        private Label lblEstado;
        private Label label3;
        private Button btnEnviar;
        private Label txtResDat;
        private TextBox txtSenData;
    }
}