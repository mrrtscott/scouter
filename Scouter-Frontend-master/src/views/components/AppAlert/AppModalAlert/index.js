import './style.css';
import { Swal } from 'sweetalert2';


///render top level errors, warning and info as banner or modal

export const AppModalAlert = (props) => {

    const modalProps = {
        icon: props.category,
        title: props.title,
        text: props.text,
    };

    if (props.posActionLabel === '' && props.negActionLabel === '') {
        modalProps.showCloseButton = true;
    }

    if (props.posActionLabel === '') {
        modalProps.showConfirmationButton = false;
    } else {
        modalProps.showConfirmationButton = true;
        modalProps.confirmationButtonText = props.posActionLabel;
    }

    if (props.negActionLabel === '') {
        modalProps.showCancelButton = false;
    } else {
        modalProps.showCancelButton = true;
        modalProps.cancelButtonText = props.negActionLabel;
    }


    const modal = Swal.fire(modalProps).then(
        (result) => {
            if (result.isConfirmed && modalProps.posAction) {
                modalProps.posAction();
            }

            if (!result.isConfirmed && modalProps.negAction) {
                modalProps.negAction();
            }
        }
    );



    return ({ modal });
};