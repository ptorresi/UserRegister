
const digito1 = document.getElementById('digito1');
const digito2 = document.getElementById('digito2');
const digito3 = document.getElementById('digito3');
const digito4 = document.getElementById('digito4');
const digito5 = document.getElementById('digito5');



function pasarFoco(codigoTecla, digito){
    
    if(codigoTecla!==8){
        switch(digito){
            case 1:
                this.digito2.focus();
                break;
            case 2:
                this.digito3.focus();
                break;
            case 3:
                this.digito4.focus();
                break;
            case 4:
                this.digito5.focus();
                break;
            default:
                return;
                
        }
    } else {
        switch(digito){
            case 5:
                this.digito4.focus();
                break;
            case 4:
                this.digito3.focus();
                break;
            case 3:
                this.digito2.focus();
                break;
            case 2:
                this.digito1.focus();
                break;
            default:
                return;
                
        }
    }
   
}