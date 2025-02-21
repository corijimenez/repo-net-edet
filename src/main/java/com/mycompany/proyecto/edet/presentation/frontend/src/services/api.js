const API_URL = "http://localhost:8080/api/cuenta"; //

// Función para registrar la cuenta
export const registerAccount = async ({
  email,
  password,
  confirmPassword,
  acceptTerms,
}) => {
  const response = await fetch(`${API_URL}/registrar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password, confirmPassword, acceptTerms }),
  });

  if (!response.ok) {
    throw new Error("Error al registrar la cuenta");
  }

  const data = await response.json();
  return data;
};
export const registrarCuenta = async (
  email,
  contraseña,
  confirmacionContraseña,
  seAceptoTerminos
) => {
  const response = await fetch(`/api/cuenta/registrar`, {
    // OJO: Sin "http://localhost:8080"
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email,
      contraseña,
      confirmacionContraseña,
      seAceptoTerminos,
    }),
  });

  if (!response.ok) {
    throw new Error("Error al registrar la cuenta");
  }

  return response.json();
};

// Función para confirmar la cuenta con el código
export const confirmAccount = async ({ email, codigo }) => {
  const response = await fetch(`${API_URL}/cuenta/confirmar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, codigo }),
  });

  if (!response.ok) {
    throw new Error("Error al confirmar la cuenta");
  }

  const data = await response.json();
  return data;
};
