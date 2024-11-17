<?php

namespace App\Http\Controllers;

use App\Models\Contenido;
use Illuminate\Http\Request;
use App\Http\Requests\ContenidoRequest;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;

class ContenidoController extends Controller
{
    //$note = Contenido::find($id);

    //Devuelve la vista index (la principal)
    public function index(){
        //$estaInvitado = DB::table('contenido_user')->where('user_id', Auth::user()->id)->where('contenido_id', $contenido->id)->first();
        $user = Auth::user(); // Obtén el usuario autenticado
        //$contenidos = Contenido::all();
        if($user->esProfesor){
            $contenidos = $user->contenido;
        } else {
            $contenidos = $user->contenidos;
        }
        return view('contenido.index', compact('contenidos', 'user'));
    }

    //Devuelve la vista create
    public function create(){
        if(!Auth::user()->esProfesor){
            return redirect()->route('contenido.index');
        } else {
            return view('contenido.create');
        }
    }

    //Guarda en la base de datos el contenido del formulario
    public function store(ContenidoRequest $request){
        $user = Auth::user();
        if(!$user->esProfesor){
            return redirect()->route('contenido.index');
        } else {
            $contenido = new Contenido($request->all());
            $contenido->user_id = Auth::id();
            $contenido->save();
            return redirect()->route('contenido.index');
        }
    }

    public function edit($contenido){



        $contenido = Contenido::find($contenido);//usamos un producto que va a ser el producto editado y le damos el valor del nuevo
        if(!Auth::user()->esProfesor || !($contenido -> user_id == Auth::id())){
            return redirect()->route('contenido.index');
        } else {
            return view('contenido.edit', compact('contenido'));
        }

    }

    public function update(ContenidoRequest $request, $contenido){
        //$user = Auth::user();
        $contenido = Contenido::find($contenido);//Encontramos el producto que vamos a actualizar
        if(!Auth::user()->esProfesor || !($contenido -> user_id ==  Auth::id())){
            return redirect()->route('contenido.index');
        } else {
            $contenido -> titulo = $request->titulo;//Le damos los valores del titulo
            $contenido -> descripcion = $request->descripcion;//Le damos los valores de la descripcion
            $contenido->save();//Guardamos los resultados
            return redirect()->route('contenido.index');//Lo redigimos a la pagina
        }

    }

    public function show(Contenido $contenido){
        return view('contenido.show', compact('contenido'));
    }

    public function destroy($contenido){
        //$user = Auth::user();
        $contenido = Contenido::find($contenido);//Encontramos el producto que vamos a actualizar
        if(!Auth::user()->esProfesor || !($contenido -> user_id ==  Auth::id())){
            return redirect()->route('contenido.index');
        }else {
            $contenido->delete();
            return redirect()->route('contenido.index');
        }

    }
}
