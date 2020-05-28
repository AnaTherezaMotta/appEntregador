package com.example.app_validacao_de_campo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewMain = new ViewHolder(); {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            this.mViewMain.edit_nome = this.findViewById(R.id.edit_nome);
            this.mViewMain.edit_telefone = this.findViewById(R.id.edit_telefone);
            this.mViewMain.chec_aceite = this.findViewById(R.id.check_aceite);
            this.mViewMain.button_confirmar = this.findViewById(R.id.button_confirmar);
            this.mViewMain.edit_email = this.findViewById(R.id.edit_email);

            // Identifica os objetos que são utilizados para ação
            this.mViewMain.button_confirmar.setOnClickListener(this);

        }
        @Override
        public void onClick(View view){
            // Será tratado todos os eventos clique da tela
            // Botao salvar
            if (view.getId() == R.id.button_confirmar) {
                // Verificar se nome foi preenchido
                if (validaCampos() == false) {
                    MensagemDeErro("Os dados estão incorretos. Verifique");
                } else {
                    MensagemDeErro("Dados corretos");
                }
            }
        }
        private boolean isEmailValido(String email){

            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        private boolean validaCampos(){
            boolean resultado = false;

            if (resultado = TextUtils.isEmpty(this.mViewMain.edit_nome.getText().toString())){
                this.mViewMain.edit_nome.requestFocus();
            }
            if (resultado = !isEmailValido(this.mViewMain.edit_email.getText().toString()))
            {
                this.mViewMain.edit_email.setError("Email inválido");
                this.mViewMain.edit_email.requestFocus();
            }

            if (!this.mViewMain.chec_aceite.isChecked()) {
                resultado = false;
            }else{
                resultado = true;
            }

            if (resultado = TextUtils.isEmpty(this.mViewMain.edit_telefone.getText().toString())){
                this.mViewMain.edit_telefone.requestFocus();
            }

            if (resultado = TextUtils.isEmpty(this.mViewMain.edit_cpf.getText().toString())){
                this.mViewMain.edit_cpf.requestFocus();
            }

                        return resultado;
        }
        private void MensagemDeErro(String mensagem){
            AlertDialog.Builder Msg = new AlertDialog.Builder(this);
            Msg.setMessage(mensagem);
            Msg.setNeutralButton("OK",null);
            Msg.create();
            Msg.show();

        }
        private static class ViewHolder{
            private EditText edit_nome;
            private Button button_confirmar;
            private CheckBox chec_aceite;
            private EditText edit_telefone;
            private EditText edit_cpf;
            private EditText edit_email;
        }
    }


}
