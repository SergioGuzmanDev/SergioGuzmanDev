@extends('layouts.app')

@section('content')
<div class="body">

    <div class="contenido-back">
        <a class="back" href="{{ route('contenido.index') }}">BACK</a>
        @if(Auth::user() -> esProfesor)
        <a class="back" href="{{ route('user.indexacion', ['contenido' => $contenido->id]) }}">AÑADIR ALUMNOS</a>
        @endif
    </div>

    <div class="Contenido-contenido">
        <h1>Nombre contenido: <br>{{$contenido -> titulo}}</h1>
        <h2>Descripción:</h2>
        <p>{{$contenido -> descripcion}} <br> </p>
    </div>

</div>

<style>
    .body{
        width: 80%;
        margin: 0 auto;
        padding: 20px
    }

    .contenido-back{
        text-align: end;
        padding: 20px;
        background: linear-gradient(to right, #1f3992, #ffffffc3);
    }

    .back{
        text-decoration: none;
        color: #000000;
        padding: 10px;
        border-radius: 5px;
        background: #921f1f00;
    }

    .Contenido-contenido{
        overflow-wrap: break-word;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
        background: linear-gradient(to right, #ffffffd4, #fffffff5);
        padding: 20px;
    }


    h1{
        font-weight: bold;
        text-align: center;
        font-size: 30px;

    }

    h2{
        color: #721c24;
        text-align: start
    }

    p{
       text-align: start

    }


</style>
@endsection

