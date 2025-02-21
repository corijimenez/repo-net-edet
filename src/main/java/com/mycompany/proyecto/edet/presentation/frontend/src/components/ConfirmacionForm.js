import React, { useState } from "react";
import { confirmAccount } from "../services/api";

const ConfirmacionForm = ({ email, onSuccess }) => {
  const [codigo, setCodigo] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await confirmAccount({ email, codigo });
      onSuccess(); // Al confirmar correctamente, se hace alguna acción como redirigir o mostrar mensaje de éxito
    } catch (error) {
      setErrorMessage("Código incorrecto o expirado");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Confirmar Cuenta</h2>
      <div>
        <label>Código de confirmación</label>
        <input
          type="text"
          value={codigo}
          onChange={(e) => setCodigo(e.target.value)}
          required
        />
      </div>
      {errorMessage && <p>{errorMessage}</p>}
      <button type="submit">Confirmar</button>
    </form>
  );
};

export default ConfirmacionForm;
