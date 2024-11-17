
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>
    
    <div class="top">
        <h2 class="titulo">Digitan Virtual</h2>
        <p class="titulo">Hecha por Sergio, Jose Román, Jose Guerrero y Bruno</p>
    </div>
    <div class="separacion"></div>
    <style>
        
        body{
            margin: 0;
            padding: 0;
            background: radial-gradient(ellipse at bottom, #1b2735f1, #090a0f);
         
        }

        .separacion{
            height: 20px;
        }

        .top{
            background: linear-gradient(to right, #3838a100, #5f66c9);
            justify-content: center;
            display: grid;
            padding: 5px;
            filter: drop-shadow(0 0 0.75rem #000000);
        }

        .top h2{
            text-align: center;
        }

        .top p{
            text-align: center
        }

        .titulo{
            color: rgb(255, 255, 255);
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }

        .lists{
            display: flex;
            justify-content: space-around;
            align-items: center;
            justify-content: center;
            gap: 10px;
            padding: 20px;
        }

        .tipoUsuario{
            text-align: center;
            background-color: rgb(255, 255, 255);
            padding: 10px;
            border-radius: 5px;
            filter: drop-shadow(0 0 0.75rem #000000);
        }

        .bienvenido{
            background-color: rgb(242, 242, 242);
            padding: 20px;
            border-radius: 5px;
            filter: drop-shadow(0 0 0.75rem #000000);
        }

        .page{
            width: 100%;
            height: 100%;
            padding: 0px;
            margin: 0px;
        }
    
        .botonCambio{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            text-decoration: none;
            background-color: rgb(255, 255, 255);
            padding: 15px;
            border: 1px solid rgb(0, 0, 0);
            cursor: pointer;
            border-radius: 5px;
            margin-bottom: 30px;
        }

        .botonCambio:hover{
            padding: 15px;
            transform: scale(1);
            transition: 0.5s;
            background: linear-gradient(#5454aced, #0010ea00);
            color: rgb(255, 255, 255);
        }

        .botonCerrarSesion{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            text-decoration: none;
            background-color: rgb(255, 255, 255);
            padding: 15px;
            border: 1px solid rgb(0, 0, 0);
            cursor: pointer;
            border-radius: 5px;
            margin-bottom: 30px;
        }

        .botonCerrarSesion:hover{
            padding: 15px;
            transform: scale(1);
            transition: 0.5s;
            background: linear-gradient(#5454aced, #0010ea00);
            color: rgb(255, 255, 255)
        }
        .botonCreate{
            margin-top: 15px;
        }
    
        .create{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            text-decoration: none;
            color: rgb(255, 255, 255);
            background-color: rgba(255, 255, 255, 0);
            border: 1px solid rgb(0, 47, 255);
            padding: 15px;
            cursor: pointer;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 30%;
            margin: 0 auto;
            border-radius: 5px;
        }

        .contenidoTitulo{
            color: rgb(255, 255, 255);
            text-decoration: none;
            font-size: 30px;
        }
        .contenidoTitulo:hover{
            color: rgb(164, 164, 164);
            text-decoration: none;
        }

        .create:hover{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            text-decoration: none;
            background-color: rgba(107, 149, 200, 0.824);
            padding: 15px;
            transform: scale(1.2);
            transition: 0.3s;
        }
   
        ul{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 20px;
            background: linear-gradient(#4f4f91ed, #0010ea2c);
            padding-right: 38px; 
            padding-bottom: 20px;
            border-radius: 5px; 
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        
        .centrarLista{
            display: flex;
            justify-content: center;
        }

    </style>
    @yield('content')
</body>

</html>
