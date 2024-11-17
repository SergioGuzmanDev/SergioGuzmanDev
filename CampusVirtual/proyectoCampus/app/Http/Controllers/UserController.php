<?php

namespace App\Http\Controllers;

use App\Models\Contenido;
use Illuminate\Http\Request;
use App\Http\Requests\ContenidoRequest;
use Illuminate\Support\Facades\Auth;
use App\Models\User;


class UserController extends Controller
{
    public function indexacion($contenido){
        $users = User::all();
        $contenido = Contenido::find($contenido);
        return view('user.indexacion', compact('users', 'contenido'));
    }

    public function toggleProfesor(User $user)
    {
        $user->esProfesor = !$user->esProfesor; // Cambia el estado de isProfesor
        $user->save();
        return redirect()->route('contenido.index');
    }

    public function invitarAlumno($contenido, $user){ //el user es el alumno
        $profesor = Auth::user();
        $contenido = Contenido::find($contenido);
        if($profesor->id != $contenido->user_id){
            return redirect()->route('contenido.index');
        }
        $user = User::find($user);
        $contenido->users()->attach($user);
        return redirect()->route('user.indexacion', $contenido);
    }





/*
       $user->forceFill([
            'name' => $input['name'],
            'email' => $input['email'],
            'email_verified_at' => null,
        ])->save();
*/
}
