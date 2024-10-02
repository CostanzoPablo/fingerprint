import base64
import requests

# Función para convertir una imagen a Base64
def convert_image_to_base64(image_path):
    with open(image_path, "rb") as image_file:
        return base64.b64encode(image_file.read()).decode('utf-8')

# Rutas de las imágenes
image1_path = "1.jpg"
image2_path = "2.jpg"

# Convertir imágenes a Base64
fingerprint1_base64 = convert_image_to_base64(image1_path)
fingerprint2_base64 = convert_image_to_base64(image2_path)

# Crear el JSON para el POST request
data = {
    "fingerprint1": fingerprint1_base64,
    "fingerprint2": fingerprint2_base64
}

# Definir la URL del servidor
url = "http://localhost:8080/api/post"

# Enviar el POST request
response = requests.post(url, json=data)

# Mostrar la respuesta del servidor
print(f"Status Code: {response.status_code}")
print(f"Response Text: {response.text}")