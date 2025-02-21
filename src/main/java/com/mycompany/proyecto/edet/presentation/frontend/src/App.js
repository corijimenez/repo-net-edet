import React, { useState } from "react";
import CuentaForm from "./components/CuentaForm";
import ConfirmacionForm from "./components/ConfirmacionForm";

const App = () => {
  const [email, setEmail] = useState("");
  const [step, setStep] = useState("registrar"); // Paso inicial es el registro

  const handleAccountCreated = () => {
    setStep("confirm");
  };

  const handleAccountConfirmed = () => {
    alert("Cuenta confirmada con éxito");
  };

  return (
    <div>
      <h1>Registro de Cuenta</h1>
      {step === "registrar" ? (
        <CuentaForm onSuccess={handleAccountCreated} />
      ) : (
        <ConfirmacionForm email={email} onSuccess={handleAccountConfirmed} />
      )}
    </div>
  );
};

export default App;
