<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ContenidoController;
use App\Http\Controllers\UserController;

Route::get('/', function () {
    return redirect()->route('login');});

/*
Route::get('/contenido', [ContenidoController::class, 'index'])->name('contenido.index');
Route::get('/contenido/create', [ContenidoController::class, 'create'])->name('contenido.create');
Route::post('/contenido/store', [ContenidoController::class, 'store'])->name('contenido.store');
Route::get('/contenido/edit/{contenido}', [ContenidoController::class, 'edit'])->name('contenido.edit');
Route::put('/contenido/update/{contenido}', [ContenidoController::class, 'update'])->name('contenido.update');
Route::get('/contenido/show/{contenido}', [ContenidoController::class, 'show'])->name('contenido.show');
Route::delete('/contenido/destroy/{contenido}', [ContenidoController::class, 'destroy'])->name('contenido.destroy');
*/

//Esto hace el CRUD completo
//Route::resource('contenido', ContenidoController::class);

Route::middleware([
    'auth:sanctum',
    config('jetstream.auth_session'),
    'verified',
])->group(function () {
    Route::get('/dashboard', function () {
        return redirect()->route('contenido.index');
        //return view('dashboard');
    })->name('dashboard');

    Route::get('/contenido', [ContenidoController::class, 'index'])->name('contenido.index');
    Route::get('/contenido/create', [ContenidoController::class, 'create'])->name('contenido.create');
    Route::post('/contenido/store', [ContenidoController::class, 'store'])->name('contenido.store');
    Route::get('/contenido/edit/{contenido}', [ContenidoController::class, 'edit'])->name('contenido.edit');
    Route::put('/contenido/update/{contenido}', [ContenidoController::class, 'update'])->name('contenido.update');
    Route::get('/contenido/show/{contenido}', [ContenidoController::class, 'show'])->name('contenido.show');
    Route::delete('/contenido/destroy/{contenido}', [ContenidoController::class, 'destroy'])->name('contenido.destroy');
    Route::post('/user/toggle-profesor/{user}', [UserController::class, 'toggleProfesor'])->name('user.toggleProfesor');
    Route::get('/user/{contenido}', [UserController::class, 'indexacion'])->name('user.indexacion'); //anyadir alumno a contenido
    Route::post('/user/invitarAlumno/{contenido}/{user}', [UserController::class, 'invitarAlumno'])->name('user.invitarAlumno');
});
