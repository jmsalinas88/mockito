# Mockito
Es un framework de pruebas unitarias, se integra con JUnit 5. Es útil para simular comportamiento de terceros en pruebas unitarias. 

Nos permite emular las dependencias de las pruebas unitarias sin necesidad de configurarlas 


# ¿Qué nos proporciona Mockito? 
- Permite escribir y ejecutar tests unitarios de código integrado por varios componentes
- Simula el comportamiento de componentes (mock, spy)
- Proporciona rapidez en las pruebas
- Útil para seguir el paradigma TDD/BDD

# Ejemplos de componentes simulados 
- Conexiones con BD
- Servicios web 
- Clases de lenta ejecución
- Clases con side-effects
- Clases con un comportamiento indefinido 

# Argument Matchers 
Los ArgumentMatchers de Mockito permiten: 
- Verificar argumentos con los que son llamados métodos de los mocks
- Simular el comportamiento de un componente
eq(), any(), anyInt(), anyString(), isNull, isnotNull(), isA(Class<T> c)

# Verify
Mockito nos proporciona una serie de métodos y mecanismos para poder verificar si algún método ha sido verificado dentro del mock

# Inyección de depdendencias
Mockito presenta anotaciones útiles
- @Mock - Permite la creación de un mock
- @Spy - Permite la creación de un spy
- @InjectMocks - Inyecta los mocks en el objeto de test

# Excepciones
Podemos simular una excepción al lanzar un método del mock
Podemos usar JUnit 5 para comprobar que se lanza dicha excepción 

# Mock vs Spy
Mock: Objeto ficticio que simular el comportamiento de sus métodos 
Spy: Objeto que llama a los métodos reales del objeto
    - No recomendables, pues perdemos el control del test
    - Sólo se usará cuando dependamos 100% de un tercero
    - Si se usa **when** con un **spy** se simula la llamada al método
    - No se puede crear spy de interfaces

# Captura de argumentos ArgumentCaptor
- Mockito permite capturar los argumentos pasados a los métodos de los mocks para poder hacer pruebas sobre ellos
- ArgumentCaptor<T>, donde T es el tipo del argumento
- Útil cuando no se puede acceder al argumento fuera del método que vamos a probar









