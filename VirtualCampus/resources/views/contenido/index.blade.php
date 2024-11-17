@extends('layouts.app')

@section('content')
<div class="page">
    @if(Auth::user() -> esProfesor)
    <div class="botonCreate">
        <a  class="create" href="{{ route('contenido.create') }}">Create new contenido</a>
    </div>
    @endif
    <div class="centrarLista">
        <ul>
            <p class="bienvenido">Bienvenido: <br> {{ $user->name }}</p> <!-- Muestra el nombre del usuario -->

            @if($user -> esProfesor)
                <p class="tipoUsuario">Usted es profesor.</p>
            @else

            <p class="tipoUsuario">Usted no es profesor.</p>

            @endif

            <form class="cerrarSesion" method="POST" action="{{ route('logout') }}">
                @csrf
                <button type="submit" class="botonCerrarSesion">
                    {{ __('Cerrar sesión') }}
                </button>
            </form>

            <form class="cambio" method="POST" action="{{ route('user.toggleProfesor', $user -> id) }}">
                @csrf
                <button type="submit" class="botonCambio">
                    {{ $user -> esProfesor ? 'Cambiar a Estudiante' : 'Cambiar a Profesor' }}
                </button>
            </form>

            @forelse($contenidos as $contenido)
                @if($user -> esProfesor && $contenido -> user_id == $user -> id)

                <li class="lists">
                    <div class="containerContenidoTitulo">
                        <a class="contenidoTitulo" href="{{ route('contenido.show', $contenido -> id)}}">{{$contenido -> titulo}}</a>
                    </div>

                    <form action="{{route('contenido.edit', $contenido ->id )}}">
                        @csrf
                        <input type="submit" value="EDIT">
                    </form>

                    <form method="POST" action="{{ route('contenido.destroy', $contenido->id) }}">
                        @csrf
                        @method('DELETE')
                        <input type="submit" value="DELETE">
                    </form>
                </li>

                @elseif(!$user->esProfesor)
                <li><a href="{{ route('contenido.show', $contenido -> id)}}">{{$contenido -> titulo}}</a></li>
                @endif
                @empty
                    <p>No hay contenidos</p>
            @endforelse
        </ul>
    </div>
</div>


<style>
    p{
        text-align: center
    }
    .centrarLista{
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 10px;
        padding: 20px;
    
    }
    li{
        list-style: none;
        background-color: #f2f2f200;
        border-radius: 5px;
        filter: drop-shadow(0 0 0.75rem #000000);
     
    }
    a{
        text-decoration: none;
        color:whitesmoke;
    
       


    }
</style>
@endsection

