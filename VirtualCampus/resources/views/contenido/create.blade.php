@extends('layouts.app')

@section('content')
<div class="Back">
<a href="{{ route('contenido.index') }}">Back</a>
</div>
<div class="Form">
<form method='POST' action={{ route('contenido.store')}}>
    @csrf
    <label>Titulo:</label>
    <input type="text" name='titulo' />

    @error('titulo')
        <p style="color:crimson">{{$message}}</p>
    @enderror

    <label>Descripcion:</label>
    <input type="text" name='descripcion' />

    @error('descripcion')
        <p style="color:crimson">{{$message}}</p>
    @enderror

    <input type="submit" value="Create"/>

</form>
</div>
<style>

    .Back{
        width: 50%;
        margin: 0 auto;
        text-align: end;
        padding: 20px;
        background: linear-gradient(to right, #1f3992, #ffffffc3);
    }

    .Back a{
        text-decoration: none;
        color: #000000;
        padding: 10px;
        border-radius: 5px;
        background: #921f1f00;
    }

    .Form{
        overflow-wrap: break-word;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
        background: linear-gradient(to right, #ffffffd4, #fffffff5);
        padding: 20px;
        width: 50%;
        margin: 0 auto;
    
    }

    form{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

    }

    label{
        font-weight: bold;
        margin-bottom: 10px;
       
    }

    input{
        padding: 10px;
        margin-bottom: 10px;
        width: 40%;
    }

    input[type='submit']{
        width: 20%;
        background: #15349221;
        color: black;
        border: 1px solid rgb(0, 0, 255);
        border-radius: 5px;
        cursor: pointer;
    }

    input[type='submit']:hover{
        transition: 0.3s;
        background: #153492;
        color: white;
    }
</style>
@endsection
